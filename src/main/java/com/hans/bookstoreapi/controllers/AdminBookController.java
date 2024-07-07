package com.hans.bookstoreapi.controllers;

import com.hans.bookstoreapi.dto.BookFormDTO;
import com.hans.bookstoreapi.entities.Book;
import com.hans.bookstoreapi.repositories.BookRepository;

import com.hans.bookstoreapi.responses.BackendResponse;
import com.hans.bookstoreapi.services.AdminBookService;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api/admin/books")
@AllArgsConstructor
@RestController
@CrossOrigin
public class AdminBookController {

   private AdminBookService adminBookService;

    @GetMapping("/list")
    public List<Book> list() {
        return adminBookService.findAll();
    }

    @GetMapping
    public Page<Book> paginate(@PageableDefault(size = 5, sort = "title") Pageable pageable){
        return adminBookService.paginate(pageable);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Book create(@RequestBody @Validated BookFormDTO bookFormDTO){
        return adminBookService.create(bookFormDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BackendResponse> get(@PathVariable Integer id){
        return adminBookService.findById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<BackendResponse> update(@PathVariable Integer id, @RequestBody @Validated BookFormDTO bookFormDTO){
        return adminBookService.update(id,  bookFormDTO);
    }

   @DeleteMapping("{id}")
    public ResponseEntity<BackendResponse> delete(@PathVariable Integer id){
        return adminBookService.delete(id);
   }
}
