package com.hans.bookstoreapi.responses;

import com.hans.bookstoreapi.entities.Book;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
