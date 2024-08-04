package com.gdsc.jwtsample.domain.auth.controller;


import com.gdsc.jwtsample.domain.auth.controller.dto.SignInDto;
import com.gdsc.jwtsample.domain.auth.service.SignInService;
import com.gdsc.jwtsample.domain.auth.service.SignUpService;
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
    @PostMapping("/sign-in")
    public SignInDto signIn(SignInDto request){
        
    }
}
