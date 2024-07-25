package com.hans.bookstoreapi.controllers;

import com.hans.bookstoreapi.responses.UploadMediaResponse;
import com.hans.bookstoreapi.services.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;

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

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> getResource(@PathVariable String filename) throws IOException {
        Resource resource = storageService.loadAsResource(filename);
        String contentType =  Files.probeContentType(resource.getFile().toPath());
        return ResponseEntity
                .status(200)
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(resource);
    }

}
