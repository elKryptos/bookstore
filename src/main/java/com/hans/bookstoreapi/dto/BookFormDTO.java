package com.hans.bookstoreapi.dto;

import lombok.Data;

@Data
public class BookFormDTO {
    private String title;
    private String slug;
    private String description;
    private Float price;
    private String coverPath;
    private String filePath;
}
