package com.gdsc.cmd.domain.auth.controller.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Digits;

@Builder
@Getter
public class SignupRequest {

    @NotBlank(message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 5, max = 30, message = "account_id는 5글자 이상, 30글자 이하여야 합니다.")
    private String accountId;

    @NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;" +
            "<=>?@＼^_`{|}~]{8,60}$",
            message = "password는 소문자, 숫자, 특수문자가 포함되어야 합니다.")
    private String password;

    @NotNull(message = "email은 Null을 허용하지 않습니다.")
    @NotBlank(message = "email은 공백, 띄어쓰기를 허용하지 않습니다.")
    private String email;

    @NotNull(message = "phonenumber는 Null을 허용하지 않습니다.")
    @Digits(integer = 15, fraction = 0, message = "phonenumber는 최대 15자리 숫자여야 합니다.")
    private Long phonenumber;

    @NotNull(message = "major는 Null을 허용하지 않습니다.")
    @NotBlank(message = "major는 공백, 띄어쓰기를 허용하지 않습니다.")
    private String major;
}
