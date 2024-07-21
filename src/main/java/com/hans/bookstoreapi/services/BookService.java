package com.hans.bookstoreapi.services;

import com.hans.bookstoreapi.model.entity.Book;
import com.hans.bookstoreapi.exception.ResourceNotFoundException;
import com.hans.bookstoreapi.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    BookRepository bookRepository;

    public List<Book> getLast6Books() {
        return bookRepository.findTop6ByOrderByCreatedAtDesc();
    }

    public Book findBySlug(String slug) {
        return bookRepository.findBySlug(slug)
                .orElseThrow(ResourceNotFoundException::new);

    }

    public Page<Book> paginate(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }


}
