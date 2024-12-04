package com.upload.files.upload_files.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.upload.files.upload_files.model.File;
import com.upload.files.upload_files.repository.FileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;

    public File saveFile(MultipartFile file) throws Exception{
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        if (filename.contains("...")) {
            throw new Exception("Invalid file: " + filename);
        }
    
        File model = new File(filename, file.getContentType(), file.getBytes());
        return fileRepository.save(model); 
    }

    public File getFile(String fileId) {
        return fileRepository.findById(fileId)
            .orElseThrow(() -> new RuntimeException("File not found: " + fileId));
    }

    public List<File> getListOfFiles(){
        return fileRepository.findAll();
    }
}
