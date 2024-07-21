package com.hans.bookstoreapi.controllers;

import com.hans.bookstoreapi.model.entity.Book;
import com.hans.bookstoreapi.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/book")
@RestController
@CrossOrigin
public class BookController {

    BookService bookService;

    @GetMapping("/last")
    public List<Book> getLast(){
        return bookService.getLast6Books();
    }

    @GetMapping("{slug}")
    public Book findBySlug(@PathVariable String slug){
        return bookService.findBySlug(slug);
    }

    @GetMapping()
    public Page<Book> paginate(@PageableDefault(sort = "title", size = 5) Pageable pageable){
        return bookService.paginate(pageable);
    }
}
