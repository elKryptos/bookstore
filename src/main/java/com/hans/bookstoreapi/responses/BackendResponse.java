package com.hans.bookstoreapi.responses;

import com.hans.bookstoreapi.entities.Book;
import lombok.Data;


@Data
public class BackendResponse {

    private String msg;
    private Book book;

    public BackendResponse(String msg) {
        super();
        this.msg = msg;
    }

    public BackendResponse(String msg, Book book) {
        super();
        this.msg = msg;
        this.book = book;
    }

}
