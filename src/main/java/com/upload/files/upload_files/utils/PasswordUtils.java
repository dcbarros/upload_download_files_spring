package com.upload.files.upload_files.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
    public static String encoder(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
}
