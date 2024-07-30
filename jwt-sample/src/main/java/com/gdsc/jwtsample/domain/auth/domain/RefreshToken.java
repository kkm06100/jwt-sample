package com.gdsc.jwtsample.domain.auth.domain;


import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Builder
@RedisHash
public class RefreshToken {
    private String accountId;

    private String refreshToken;

    private Long expiration;

    public RefreshToken updateExpiration(Long expiration){
        this.expiration = expiration;
        return this;
    }
}
