package com.gdsc.jwtsample.global.security.jwt;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Base64;

@Getter
@Configuration
public class JwtProperties {

    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.accessExp}")
    private Long accessExp;

    @Value("${jwt.refreshExp}")
    private Long refreshExp;

    @Value("${jwt.header}")
    private String header;

    @Value("${jwt.prefix}")
    private String prefix;

    @PostConstruct
    private void encodeSecretKey() {
        this.secretKey = Base64.getEncoder().encodeToString(this.secretKey.getBytes());
    }
}