package com.terraplanistas.api.service;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    public FileStorageService() throws IOException {
        this.fileStorageLocation = Paths.get("uploads").toAbsolutePath().normalize();
        Files.createDirectories(this.fileStorageLocation);
    }

    public String storeFile(MultipartFile file) throws IOException {
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path target = this.fileStorageLocation.resolve(filename);
        Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
        return filename;
    }

    public Resource loadFile(String filename) throws IOException {
        Path path = this.fileStorageLocation.resolve(filename).normalize();
        return new UrlResource(path.toUri());
    }
}
