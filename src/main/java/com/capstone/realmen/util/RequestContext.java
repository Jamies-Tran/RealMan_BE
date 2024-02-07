package com.capstone.realmen.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.capstone.realmen.dto.account.Account;
import com.capstone.realmen.security.jwt.JwtService;
import com.capstone.realmen.service.account.AccountUseCaseService;
import java.util.Objects;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class RequestContext {
    @Lazy
    @Autowired
    private JwtService jwtService;

    @Lazy
    @Autowired
    private AccountUseCaseService accountUseCaseService;

    private HttpServletRequest request() {
        ServletRequestAttributes requestAttribute = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttribute.getRequest();
    }

    private Account getAccountFromRequest() {
        String getIdentifier = jwtService.getIdentifyFromHeader(request());
        return accountUseCaseService.findByPhoneOrStaffCode(getIdentifier);
    }

    public Long getAccountId() {
        return getAccountFromRequest().accountId();
    }

    public String getName() {
        return String.format("%s %s", getAccountFromRequest().lastName(), getAccountFromRequest().firstName());
    }

    public String getPhone() {
        return getAccountFromRequest().phone();
    }

    public String getStaffCode() {
        return Objects.nonNull(getAccountFromRequest().staffCode()) ? getAccountFromRequest().staffCode() : null;
    }
}
