package com.upload.files.upload_files.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.upload.files.upload_files.model.File;
import com.upload.files.upload_files.model.FileResponse;
import com.upload.files.upload_files.service.FileService;
import com.upload.files.upload_files.exception.InvalidFileException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @PostMapping("/upload")
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) throws InvalidFileException {
        File model = fileService.saveFile(file);
        String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/file/download/")
            .path(model.getId())
            .toUriString();
        return new FileResponse(model.getFileName(), model.getFileType(), fileUri);
    }

    @PostMapping("/uploadMultipleFiles")
    public List<FileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        if (files == null || files.length == 0) {
            throw new InvalidFileException("No files provided for upload.");
        }

        return Arrays.stream(files)
                .map(file -> {
                    try {
                        return uploadFile(file);
                    } catch (InvalidFileException e) {
                        throw new InvalidFileException("Error uploading file: " + file.getOriginalFilename(), e);
                    }
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String id) {
        File model = fileService.getFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + model.getFileName() + "\"")
                .contentType(org.springframework.http.MediaType.parseMediaType(model.getFileType()))
                .body(new ByteArrayResource(model.getFileData()));
    }

    @GetMapping("/allfiles")
    public List<File> getListFiles() {
        return fileService.getListOfFiles();
    }
}
