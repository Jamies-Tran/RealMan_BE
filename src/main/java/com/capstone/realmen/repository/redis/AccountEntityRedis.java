package com.capstone.realmen.repository.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@RedisHash("account")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountEntityRedis {
        @Id
        String phone;
        String otp;
        @TimeToLive(unit = TimeUnit.HOURS)
        Long duration;
}
