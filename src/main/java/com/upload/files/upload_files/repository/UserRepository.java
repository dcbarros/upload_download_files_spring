package com.upload.files.upload_files.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upload.files.upload_files.model.User;

public interface UserRepository  extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}
