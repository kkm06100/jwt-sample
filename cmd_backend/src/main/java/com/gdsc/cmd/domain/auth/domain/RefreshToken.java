package com.gdsc.cmd.domain.auth.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@RedisHash("refreshToken")
public class RefreshToken {
    @Id
    private String accountId;

    private String refreshToken;

    @TimeToLive
    private Long expiration;

    public RefreshToken updateExpiration(Long expiration){
        this.expiration = expiration;
        return this;
    }
}
