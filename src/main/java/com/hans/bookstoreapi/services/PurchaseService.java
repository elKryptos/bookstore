package com.hans.bookstoreapi.services;

import com.hans.bookstoreapi.exception.ResourceNotFoundException;
import com.hans.bookstoreapi.model.entity.Book;
import com.hans.bookstoreapi.model.entity.Purchase;
import com.hans.bookstoreapi.model.entity.PurchaseItem;
import com.hans.bookstoreapi.repositories.BookRepository;
import com.hans.bookstoreapi.repositories.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class PurchaseService {

    private PurchaseRepository purchaseRepository;
    private BookRepository bookRepository;

    public Purchase findById(Integer id){
        return purchaseRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    public Purchase create(List<Integer> bookIds){
        Purchase purchase = new Purchase();
        purchase.setCreatedAt(LocalDateTime.now());
        purchase.setPaymentStatus(Purchase.PaymentStatus.PENDING);
        purchase.setCustomer(null);
        float total = 0;
        for (int bookId : bookIds) {
            Book book = bookRepository
                    .findById(bookId)
                    .orElseThrow(ResourceNotFoundException::new);
            PurchaseItem purchaseItem = new PurchaseItem();
            purchaseItem.setPurchase(purchase);
            purchaseItem.setPrice(book.getPrice());
            purchaseItem.setBook(book);
            purchaseItem.setDownloadAvailable(3);
            total += book.getPrice();
        }
        purchase.setTotal(total);
        return purchaseRepository.save(purchase);
    }
}
