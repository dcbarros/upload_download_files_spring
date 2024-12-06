package com.upload.files.upload_files.model.dto;

import com.upload.files.upload_files.model.User;
import com.upload.files.upload_files.utils.PasswordUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
    private String name;
    private String password;
    private String email;

    public User dtoToModel(){
        return new User(name, PasswordUtils.encoder(password), email);
    }
}
