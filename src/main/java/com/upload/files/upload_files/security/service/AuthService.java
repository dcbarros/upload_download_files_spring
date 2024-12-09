package com.upload.files.upload_files.security.service;

import org.springframework.stereotype.Service;

import com.upload.files.upload_files.model.dto.AuthResponse;

import org.springframework.security.core.Authentication;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtService jwtService;

    public AuthResponse authenticate(Authentication authentication) {
        AuthResponse token = new AuthResponse(jwtService.generateToken(authentication));
        return token;
    }
}
