package com.hans.bookstoreapi.repositories;

import com.hans.bookstoreapi.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {

    boolean existsBySlug(String slug);
    boolean existsBySlugAndIdNot(String slug, Integer id);
}
