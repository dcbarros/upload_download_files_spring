package com.upload.files.upload_files.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upload.files.upload_files.security.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("authenticate")
    public String authenticate(
        Authentication authentication) {
      return authService.authenticate(authentication);
    }
}
