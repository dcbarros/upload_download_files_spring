package com.upload.files.upload_files.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileResponse {
    String fileName;
    String fileType;
    String fileUri;
}
