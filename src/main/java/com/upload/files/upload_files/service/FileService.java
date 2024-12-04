package com.upload.files.upload_files.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.upload.files.upload_files.model.File;
import com.upload.files.upload_files.repository.FileRepository;
import com.upload.files.upload_files.exception.FileNotFoundException;
import com.upload.files.upload_files.exception.InvalidFileException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService {
    private static final String INVALID_FILE_MESSAGE = "Invalid file: ";
    private static final String FILE_NOT_FOUND_MESSAGE = "File not found: ";

    private final FileRepository fileRepository;

    public File saveFile(MultipartFile file) throws InvalidFileException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        if (filename.contains("...") || filename.isBlank()) {
            throw new InvalidFileException(INVALID_FILE_MESSAGE + filename);
        }

        try {
            File model = new File(filename, file.getContentType(), file.getBytes());
            return fileRepository.save(model);
        } catch (Exception e) {
            throw new InvalidFileException("Failed to save file: " + filename, e);
        }
    }

    public File getFile(String fileId) {
        return fileRepository.findById(fileId)
            .orElseThrow(() -> new FileNotFoundException(FILE_NOT_FOUND_MESSAGE + fileId));
    }

    public List<File> getListOfFiles() {
        return fileRepository.findAll();
    }
}