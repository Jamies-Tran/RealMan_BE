package com.capstone.realmen.service.twilio;

import org.springframework.stereotype.Service;

import com.capstone.realmen.util.twilio.TwilioProperties;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TwilioUseCaseService {

    public void sendOTP(String phone, String otp) {
        initTwilio();
        phone = "+84".concat(phone.substring(1));
        Message.creator(new PhoneNumber(phone), new PhoneNumber(TwilioProperties.TWILIO_PHONE_NUMBER), sendOTPMsg(otp))
                .create();
    }

    private void initTwilio() {
        Twilio.init(TwilioProperties.ACCOUNT_SID, TwilioProperties.AUTH_TOKEN);
    }

    private String sendOTPMsg(String otp) {
        return String.format("Mật khẩu đăng nhập của bạn là %s", otp);
    }
}
