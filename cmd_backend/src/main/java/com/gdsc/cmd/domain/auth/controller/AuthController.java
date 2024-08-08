package com.gdsc.cmd.domain.auth.controller;

import com.gdsc.cmd.domain.auth.controller.dto.SigninRequest;
import com.gdsc.cmd.domain.auth.controller.dto.SignupRequest;
import com.gdsc.cmd.domain.auth.service.LoginService;
import com.gdsc.cmd.domain.auth.service.ReissueService;
import com.gdsc.cmd.domain.auth.service.SignUpService;
import com.gdsc.cmd.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final LoginService signInService;
    private final SignUpService signUpService;
    private final ReissueService reissueService;
    @PostMapping("/signin") // 로그인
    public TokenResponse signIn(SigninRequest request){
        return signInService.execute(request);
    }
    @PostMapping("/signup")
    public String signup(@Valid @RequestBody SignupRequest signupRequest) {
        signUpService.execute(signupRequest);
        return "User signed up successfully";
    }
    @PostMapping("/reissue")
    public TokenResponse reissue(@RequestHeader(name = "AUTHORIZATION_HEADER") String refreshToken) {
        return reissueService.reissue(refreshToken);
    }
}
