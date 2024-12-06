package com.upload.files.upload_files.service;

import org.springframework.stereotype.Service;

import com.upload.files.upload_files.model.dto.UserCreateRequest;
import com.upload.files.upload_files.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public void saveNewUser(UserCreateRequest request){
        userRepository.save(request.dtoToModel());
    }

}
