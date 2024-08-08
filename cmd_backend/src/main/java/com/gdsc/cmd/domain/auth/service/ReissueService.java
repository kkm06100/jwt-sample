package com.gdsc.cmd.domain.auth.service;


import com.gdsc.cmd.global.security.TokenResponse;
import com.gdsc.cmd.global.security.jwt.JwtReissueUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ReissueService {

    private final JwtReissueUtil jwtReissueUtil;

    @Transactional
    public TokenResponse reissue(String refreshToken) {
        return jwtReissueUtil.reissue(refreshToken);
    }

}