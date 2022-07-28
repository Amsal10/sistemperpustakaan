package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/req")
public class UploadController {

    @Autowired
    private UploadFileService uploadFileService;

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        uploadFileService.uploadToLocal(file);
    }

    @PostMapping("/uploaddb")
    public void uploadFiledb(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        uploadFileService.uploadToDb(file);
        uploadFileService.uploadToLocal(file);
    }
}