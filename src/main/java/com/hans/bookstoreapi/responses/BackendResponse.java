package com.hans.bookstoreapi.responses;

import com.hans.bookstoreapi.entities.Book;
import lombok.Data;
import org.springframework.web.bind.MethodArgumentNotValidException;

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

    public BackendResponse(MethodArgumentNotValidException exception) {
        this.msg = exception.getBindingResult().getFieldError().getDefaultMessage();
    }

}
