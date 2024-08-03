package com.gdsc.jwtsample.domain.auth.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SignUpDto {
    private String accountId;
    private String password;
    private String email;
}
