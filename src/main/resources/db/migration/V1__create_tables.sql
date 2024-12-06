CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE file_upload_download (
    id VARCHAR(255) PRIMARY KEY,
    file_id VARCHAR(255),
    file_name VARCHAR(255),
    file_type VARCHAR(255),
    file_data BLOB
);
