package com.gdsc.jwtsample.domain.auth.service;


import com.gdsc.jwtsample.domain.auth.domain.RefreshToken;
import com.gdsc.jwtsample.domain.auth.domain.repository.RefreshTokenRepository;
import com.gdsc.jwtsample.domain.user.domain.User;
import com.gdsc.jwtsample.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Locale;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional


public class LogoutService {

    private final UserFacade userFacade;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void execute() {
        Optional<User> user = userFacade.getCurrentUser();
        user = Optional.ofNullable(User.builder().
                accountId(user.get().getAccountId()).
                password(user.get().getPassword()).
                email(user.get().getEmail()).
                deviceToken(null).
                build());

        RefreshToken refreshToken = refreshTokenRepository.findById(user.get().getAccountId())
                .orElseThrow(() -> new RuntimeException(""));

        refreshTokenRepository.delete(refreshToken);
    }

}