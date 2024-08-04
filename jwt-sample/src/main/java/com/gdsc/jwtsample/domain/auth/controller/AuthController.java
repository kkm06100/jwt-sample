package com.gdsc.jwtsample.domain.auth.controller;


import com.gdsc.jwtsample.domain.auth.controller.dto.SignInDto;
import com.gdsc.jwtsample.domain.auth.controller.dto.SignUpDto;
import com.gdsc.jwtsample.domain.auth.service.SignInService;
import com.gdsc.jwtsample.domain.auth.service.SignUpService;
import com.gdsc.jwtsample.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final SignInService signInService;
    private final SignUpService signUpService;
    @PostMapping("/signin") // 로그인
    public TokenResponse signIn(SignInDto request){
        return signInService.execute(request);

    }
    @PostMapping("/signup") // 회원 가입
    public TokenResponse signUp(SignUpDto request){
        return signUpService.execute(request);
    }

}
