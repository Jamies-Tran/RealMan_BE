package com.capstone.realmen.service.account;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.capstone.realmen.controller.error.exceptions.ResourceDuplicatedException;
import com.capstone.realmen.controller.error.exceptions.ResourceNotFoundException;
import com.capstone.realmen.dto.account.Account;
import com.capstone.realmen.dto.account.AccountMapper;
import com.capstone.realmen.dto.auditable.Auditable;
import com.capstone.realmen.dto.enums.ERole;
import com.capstone.realmen.repository.database.account.AccountEntity;
import com.capstone.realmen.repository.database.account.AccountRepository;
import com.capstone.realmen.security.encoder.AppPasswordEncoder;
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
    private final AccountRepository accountRepository;
    @NonNull
    private final AccountMapper accountMapper;
    @NonNull
    private final RequestContext requestContext;
    @NonNull
    private final AppPasswordEncoder passwordEncoder;
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
                .updatePassword(account, passwordEncoder.passwordEncoder().encode(appDefaultPassword));
        AccountEntity accountEntity = accountMapper.create(updateAccount,
                Auditable.ofWeb(requestContext.getStaffCode()));
        accountRepository.save(accountEntity);
    }

    public void save(Account account) {
        if (accountRepository.existsByPhone(account.phone())) {
            throw new ResourceDuplicatedException();
        }
        AccountEntity accountEntity = accountMapper.create(account, Auditable.of());
        accountMapper.updateBeforeSave(accountEntity, passwordEncoder.passwordEncoder().encode(appMobDefaultPassword),
                ERole.CUSTOMER);
        accountRepository.save(accountEntity);
    }

    public void createOTP(String phone) {
        AccountEntity foundAccount = accountRepository.findByPhone(phone).orElseThrow(ResourceNotFoundException::new);
        LocalDateTime otpExpiredAt = LocalDateTime.now().plusMinutes(otpExpiredTime);
        String otp = generateOtp();
        while (accountRepository.existsByPassword(otp)) {
            otp = generateOtp();
        }
        foundAccount.setPassword(passwordEncoder.passwordEncoder().encode(otp));
        foundAccount.setPassExpiredAt(otpExpiredAt);
        foundAccount.setIsPassAvailable(true);
        accountRepository.save(foundAccount);
        twilioUseCaseService.sendOTP(phone, otp);
    }

    public void disablePassword(Long accountId) {
        AccountEntity foundAccount = accountRepository.findById(accountId).orElseThrow(ResourceNotFoundException::new);
        foundAccount.setIsPassAvailable(false);
        accountRepository.save(foundAccount);
    }

    private String generateOtp() {
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            otp.append(new Random().nextInt(9));
        }
        return otp.toString();
    }
}
