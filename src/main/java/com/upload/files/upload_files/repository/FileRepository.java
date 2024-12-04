package com.upload.files.upload_files.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upload.files.upload_files.model.File;

public interface FileRepository extends JpaRepository<File,String>{
    
}
