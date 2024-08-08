package com.gdsc.cmd.global.security;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class TokenResponse { // dto
    private String accessToken;

    private String refreshToken;
}
