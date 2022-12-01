package com.example.awss3access.controller;

import com.example.awss3access.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class StorageController {

    @Autowired
    private StorageService service;

    @GetMapping("/download/{fileName}")
    public ResponseEntity getFileData(@PathVariable("fileName") String fileName) throws IOException {
        byte[] data = service.getFileData(fileName);
        return ResponseEntity
                .ok()
                .body(data);
    }
}
