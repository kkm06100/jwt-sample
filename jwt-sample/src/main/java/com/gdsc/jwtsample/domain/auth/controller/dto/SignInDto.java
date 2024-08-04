package com.gdsc.jwtsample.domain.auth.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignInDto {
    private String accountId;
    private String password;
}
