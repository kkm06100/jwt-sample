package com.gdsc.cmd.domain.auth.service;


import com.gdsc.cmd.domain.auth.controller.dto.SigninRequest;
import com.gdsc.cmd.domain.user.domain.User;
import com.gdsc.cmd.domain.user.domain.repository.UserRepository;
import com.gdsc.cmd.global.security.TokenResponse;
import com.gdsc.cmd.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenResponse execute(SigninRequest request) {

        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> new UsernameNotFoundException(""));



        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException();
        }

        return jwtTokenProvider.createToken(user.getAccountId());
    }

}