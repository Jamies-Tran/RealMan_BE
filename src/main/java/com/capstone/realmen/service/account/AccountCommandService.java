package com.capstone.realmen.service.account;

import java.util.Random;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.capstone.realmen.controller.error.exceptions.ResourceDuplicatedException;
import com.capstone.realmen.controller.error.exceptions.ResourceNotFoundException;
import com.capstone.realmen.controller.error.exceptions.WrongOTPException;
import com.capstone.realmen.controller.web.account.models.ChangePasswordRequest;
import com.capstone.realmen.dto.account.Account;
import com.capstone.realmen.dto.account.AccountMapper;
import com.capstone.realmen.dto.auditable.Auditable;
import com.capstone.realmen.dto.enums.EAccountStatus;
import com.capstone.realmen.dto.enums.ERole;
import com.capstone.realmen.repository.database.account.AccountEntity;
import com.capstone.realmen.repository.database.account.AccountRepository;
import com.capstone.realmen.repository.redis.AccountCache;
import com.capstone.realmen.repository.redis.AccountEntityRedis;
import com.capstone.realmen.security.encoder.AppPasswordEncoder;
import com.capstone.realmen.security.jwt.JwtService;
import com.capstone.realmen.service.twilio.TwilioUseCaseService;
import com.capstone.realmen.util.RequestContext;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountCommandService {
    @NonNull
    private final TwilioUseCaseService twilioUseCaseService;
    @NonNull
    private final JwtService jwtService;
    @NonNull
    private final AccountRepository accountRepository;
    @NonNull
    private final AccountCache accountCache;
    @NonNull
    private final AccountMapper accountMapper;
    @NonNull
    private final RequestContext requestContext;
    @NonNull
    private final AppPasswordEncoder appPasswordEncoder;
    @Value("${app.default.password}")
    private String appDefaultPassword;
    @Value("${app.mobile.default.password}")
    private String appMobDefaultPassword;
    @Value("${otp.expired.time}")
    private Long otpExpiredTime;

    public void saveWeb(Account account) {
        if (accountRepository.existsByPhone(account.phone())
                || accountRepository.existsByStaffCode(account.staffCode())) {
            throw new ResourceDuplicatedException();
        }
        Account updateAccount = accountMapper
                .updatePassword(account,
                        appPasswordEncoder.passwordEncoder().encode(appDefaultPassword));
        AccountEntity accountEntity = accountMapper.create(updateAccount,
                Auditable.ofWeb(requestContext.getAccountId().toString()));
        accountRepository.save(accountEntity);
    }

    public void save(Account account) {
        if (accountRepository.existsByPhone(account.phone())) {
            throw new ResourceDuplicatedException();
        }
        AccountEntity accountEntity = accountMapper.create(account, Auditable.ofNoIdentifier());
        accountMapper.updateBeforeSave(
                accountEntity,
                appPasswordEncoder.passwordEncoder().encode(appMobDefaultPassword),
                ERole.CUSTOMER);
        accountRepository.save(accountEntity);
    }

    public void createOTP(String phone) {
        AccountEntity foundAccount = accountRepository.findByPhone(phone)
                .orElseThrow(ResourceNotFoundException::new);
        String otp = generateOtp();
        while (accountRepository.existsByPassword(otp)) {
            otp = generateOtp();
        }
        AccountEntityRedis cachedAccount = AccountEntityRedis.builder()
                .otp(otp)
                .phone(phone)
                .duration(jwtService.getJwtDuration())
                .build();
        foundAccount.setPassword(appPasswordEncoder.passwordEncoder().encode(otp));
        accountCache.save(cachedAccount);
        accountRepository.save(foundAccount);
        twilioUseCaseService.sendOTP(phone, otp);
    }

    private String generateOtp() {
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            otp.append(new Random().nextInt(9));
        }
        return otp.toString();
    }

    public void createOTPChangePassword(String phone) {
        String otp = generateOtp();
        accountCache.findById(phone).ifPresent(a -> accountCache.delete(a));
        AccountEntityRedis account = AccountEntityRedis.builder()
                .phone(phone)
                .otp(otp)
                .duration(15L)
                .build();
        accountCache.save(account);
        twilioUseCaseService.sendChangePassOTP(phone, otp);
    }

    public void changePassword(ChangePasswordRequest changePasswordRequest) {
        AccountEntityRedis cachedAccount = accountCache.findById(changePasswordRequest.phone())
                .orElseThrow(ResourceNotFoundException::new);
        if (!changePasswordRequest.otp().equals(cachedAccount.getOtp())) {
            throw new WrongOTPException();
        }
        AccountEntity foundAccount = accountRepository.findByPhone(changePasswordRequest.phone())
                .orElseThrow(ResourceNotFoundException::new);
        accountMapper.changePassword(foundAccount, appPasswordEncoder.passwordEncoder().encode(changePasswordRequest.newPassword()),
                Auditable.updateEntity(foundAccount, foundAccount.getAccountId().toString()));
        accountRepository.save(foundAccount);
        accountCache.deleteById(changePasswordRequest.phone());
    }

    public void updateMe(Account account) {
        AccountEntity foundAccount = accountRepository.findById(requestContext.getAccountId())
                .orElseThrow(ResourceNotFoundException::new);
        Auditable auditable = Auditable.updateEntity(foundAccount, requestContext.getAccountId().toString());
        accountMapper.update(foundAccount, account, auditable);
        accountRepository.save(foundAccount);
    }

    public void deleteAccount(Long accountId) {
        AccountEntity foundAccount = accountRepository.findById(accountId)
                .orElseThrow(ResourceNotFoundException::new);
        accountMapper.updateStatus(foundAccount, EAccountStatus.DELETED,
                Auditable.updateEntity(foundAccount, requestContext.getAccountId().toString()));
        accountRepository.save(foundAccount);
    }
}
