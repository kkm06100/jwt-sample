package com.gdsc.jwtsample.domain.auth.service;

import com.gdsc.jwtsample.domain.auth.controller.dto.SignInDto;
import com.gdsc.jwtsample.domain.user.domain.User;
import com.gdsc.jwtsample.domain.user.domain.repository.UserRepository;
import com.gdsc.jwtsample.global.security.TokenResponse;
import com.gdsc.jwtsample.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class SignInService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenResponse execute(SignInDto request) {

        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> new UsernameNotFoundException(""));

        user = User.builder().
                accountId(user.getAccountId()).
                password(user.getPassword()).
                email(user.getEmail()).
                deviceToken(request.getDeviceToken()).
                build();

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException();
        }

        return jwtTokenProvider.createToken(user.getAccountId());
    }

}
