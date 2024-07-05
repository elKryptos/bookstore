package com.hans.bookstoreapi.repositories;

import com.hans.bookstoreapi.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
