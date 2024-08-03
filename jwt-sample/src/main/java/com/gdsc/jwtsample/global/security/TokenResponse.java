package com.gdsc.jwtsample.global.security;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class TokenResponse { // dto
    private String accessToken;

    private String refreshToken;
}
