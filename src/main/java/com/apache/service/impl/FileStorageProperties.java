package com.apache.service.impl;

import org.springframework.boot.context.properties.*;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {

    private String uploadDirectory;

    public String getUploadDirectory() {
        return uploadDirectory;
    }

    public void setUploadDirectory(String uploadDirectory) {
        this.uploadDirectory = uploadDirectory;
    }

}
