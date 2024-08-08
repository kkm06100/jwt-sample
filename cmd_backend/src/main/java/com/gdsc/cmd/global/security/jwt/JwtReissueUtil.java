package com.gdsc.cmd.global.security.jwt;

import com.amazonaws.services.kms.model.ExpiredImportTokenException;
import com.gdsc.cmd.global.security.TokenResponse;
import com.gdsc.cmd.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
@Transactional
public class JwtReissueUtil { // 토큰 관리자

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public TokenResponse reissue(String refreshToken) { // 액세스 토큰 재발행

        if(!isRefreshToken(refreshToken)) { // token이 refreshToken인지 확인
            throw new JwtException("not refreshToken");
        }

        String accountId = getId(refreshToken);

        return TokenResponse.builder() // 토큰 제작
                .accessToken(jwtTokenProvider.createAccessToken(accountId))
                .refreshToken(refreshToken)
                .build();
    }

    private String getId(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new ExpiredImportTokenException("");//
        } catch (Exception e) {
            throw new ExpiredImportTokenException("");//
        }
    }

    private boolean isRefreshToken(String token) { // refresh 토큰인지 확인
        return getClaims(token).get("type").equals("refresh");
    }

    public Authentication getAuthentication(String token) { // 토큰 유효성 확인
        Claims claims = getClaims(token);
        UserDetails userDetails = authDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

}