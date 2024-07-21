package com.hans.bookstoreapi.repositories;

import com.hans.bookstoreapi.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    boolean existsBySlug(String slug);
    boolean existsBySlugAndIdNot(String slug, Integer id);
    Optional<Book> findBySlug(String slug);
    List<Book> findTop6ByOrderByCreatedAtDesc();
}
