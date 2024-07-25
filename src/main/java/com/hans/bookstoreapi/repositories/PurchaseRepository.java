package com.hans.bookstoreapi.repositories;

import com.hans.bookstoreapi.model.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository <Purchase, Integer> {
}
