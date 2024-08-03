package com.gdsc.jwtsample.domain.auth.service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.gdsc.jwtsample.domain.auth.domain.dto.SignUpDto;
import com.gdsc.jwtsample.domain.user.domain.User;
import com.gdsc.jwtsample.domain.user.domain.repository.UserRepository;
import com.gdsc.jwtsample.domain.user.facade.UserFacade;
import com.gdsc.jwtsample.global.security.TokenResponse;

import com.gdsc.jwtsample.global.security.jwt.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignUpService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    public TokenResponse signUp(SignUpDto signUpDto){
        userFacade.checkUserExists(signUpDto.getAccountId());


        String password = passwordEncoder.encode(signUpDto.getPassword());

        userRepository.save(
                User.builder()
                        .accountId(signUpDto.getAccountId())
                        .password(password)
                        .build()
        );

        return jwtTokenProvider.createToken(signUpDto.getAccountId());

    }
}
