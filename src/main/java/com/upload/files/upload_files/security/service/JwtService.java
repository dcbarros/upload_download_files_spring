package com.upload.files.upload_files.security.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final JwtEncoder encoder;

    public String generateToken(Authentication authentication){
        Instant now = Instant.now();
        long expiry = 36000L;
    
        String scope = authentication
            .getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors
                .joining(" "));
    
        JwtClaimsSet claims = JwtClaimsSet.builder()
            .issuer("spring-security-jwt")
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expiry))
            .subject(authentication.getName())
            .claim("scope", scope)
            .build();
    
        return encoder.encode(
            JwtEncoderParameters.from(claims))
            .getTokenValue();
    }
    
}
