package com.hans.bookstoreapi.services;

import com.hans.bookstoreapi.model.dto.BookFormDTO;
import com.hans.bookstoreapi.model.entity.Book;
import com.hans.bookstoreapi.exception.BadRequestException;
import com.hans.bookstoreapi.repositories.BookRepository;
import com.hans.bookstoreapi.responses.BackendResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class AdminBookService {

    BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Page<Book> paginate(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public Book create(BookFormDTO bookFormDTO){
        String slug = bookFormDTO.getSlug();
        boolean slugAlreadyExist = bookRepository.existsBySlug(slug);
        if(slugAlreadyExist){
            throw  new BadRequestException("Slug already exists");
        }
        Book book = new Book();
        book.setTitle(bookFormDTO.getTitle());
        book.setDescription(bookFormDTO.getDescription());
        book.setPrice(bookFormDTO.getPrice());
        book.setSlug(bookFormDTO.getSlug());
        book.setCoverPath(bookFormDTO.getCoverPath());
        book.setFilePath(bookFormDTO.getFilePath());
        book.setCreatedAt(LocalDateTime.now());
        return bookRepository.save(book);
    }

    public ResponseEntity<BackendResponse> findById( Integer id){
        if(!bookRepository.existsById(id)){
            return ResponseEntity.status(404).body(new BackendResponse("Book not found"));
        } else {
            Book book = bookRepository.findById(id).get();
            return ResponseEntity.status(200).body(new BackendResponse("Book found", book));
        }
    }

    public ResponseEntity<BackendResponse> update(Integer id, BookFormDTO bookFormDTO){
        String slug = bookFormDTO.getSlug();
        boolean slugAlreadyExist = bookRepository.existsBySlugAndIdNot(slug, id);

        if(!bookRepository.existsById(id)){
            return ResponseEntity.status(404).body(new BackendResponse("Book not found"));
        } else if (slugAlreadyExist) {
            return ResponseEntity.status(400).body(new BackendResponse("Slug already exists"));
        } else {
            Book bookToUpdate = bookRepository.findById(id).get();
            bookToUpdate.setTitle(bookFormDTO.getTitle());
            bookToUpdate.setDescription(bookFormDTO.getDescription());
            bookToUpdate.setPrice(bookFormDTO.getPrice());
            bookToUpdate.setSlug(bookFormDTO.getSlug());
            bookToUpdate.setCoverPath(bookFormDTO.getCoverPath());
            bookToUpdate.setFilePath(bookFormDTO.getFilePath());
            //bookToUpdate.setCreatedAt(bookToUpdate.getCreatedAt());
            bookToUpdate.setUpdatedAt(LocalDateTime.now());
            Book savedBook = bookRepository.save(bookToUpdate);
            return ResponseEntity.status(200).body(new BackendResponse("Book updated", savedBook));
        }
    }

    public ResponseEntity<BackendResponse> delete(Integer id){
        if(!bookRepository.existsById(id)){
            return ResponseEntity.status(404).body(new BackendResponse("Book not found"));
        } else {
            Book bookToDelete = bookRepository.findById(id).get();
            bookRepository.delete(bookToDelete);
            return ResponseEntity.status(204).body(new BackendResponse("Book deleted"));
        }
    }


}
