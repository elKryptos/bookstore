package com.hans.bookstoreapi.controllers;

import com.hans.bookstoreapi.responses.UploadMediaResponse;
import com.hans.bookstoreapi.services.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RequestMapping("/api/media")
@RestController
public class MediaController {

    private StorageService storageService;

    @PostMapping("/upload")
    public UploadMediaResponse path(@RequestParam("file") MultipartFile multipartFile){
        String path = storageService.store(multipartFile);
        return new UploadMediaResponse(path);
    }

}
