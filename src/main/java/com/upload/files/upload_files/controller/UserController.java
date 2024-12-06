package com.upload.files.upload_files.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upload.files.upload_files.model.dto.UserCreateRequest;
import com.upload.files.upload_files.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/sign-in")
    public void signIn(@RequestBody UserCreateRequest request){
        userService.saveNewUser(request);
    }
}
