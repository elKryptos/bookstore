package com.hans.bookstoreapi.repositories;

import com.hans.bookstoreapi.model.entity.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Integer> {
}
