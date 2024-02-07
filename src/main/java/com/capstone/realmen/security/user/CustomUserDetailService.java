package com.capstone.realmen.security.user;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.capstone.realmen.dto.account.Account;
import com.capstone.realmen.service.account.AccountUseCaseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    @NonNull
    private final AccountUseCaseService accountUseCaseService;

    @Override
    public UserDetails loadUserByUsername(String phoneOrStaffCode) throws UsernameNotFoundException {
        Account account = accountUseCaseService.findByPhoneOrStaffCode(phoneOrStaffCode);
        return User.builder().username(phoneOrStaffCode).password(account.password())
                .authorities(account.role().authority()).build();
    }

}
