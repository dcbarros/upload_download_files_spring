package com.upload.files.upload_files.controller;

import org.springframework.web.bind.annotation.RestController;

import com.upload.files.upload_files.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
}
