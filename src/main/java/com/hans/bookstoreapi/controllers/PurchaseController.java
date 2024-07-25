package com.hans.bookstoreapi.controllers;

import com.hans.bookstoreapi.model.entity.Purchase;
import com.hans.bookstoreapi.repositories.PurchaseRepository;
import com.hans.bookstoreapi.services.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/purchases")
@AllArgsConstructor
@RestController
public class PurchaseController {

    private PurchaseService purchaseService;

    @PostMapping
    public Purchase create() {
        return purchaseService.create(null);
    }
}
