package com.upload.files.upload_files.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.upload.files.upload_files.exception.UserNotFoundException;
import com.upload.files.upload_files.model.impl.UserAuth;
import com.upload.files.upload_files.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).map(UserAuth::new).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
    
}
