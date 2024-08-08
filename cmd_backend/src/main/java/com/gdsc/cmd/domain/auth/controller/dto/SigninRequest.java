package com.gdsc.cmd.domain.auth.controller.dto;


import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class SigninRequest {
    @NotBlank(message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    private String accountId;
    @NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    private String password;

}
