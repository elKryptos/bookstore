package com.hans.bookstoreapi.controllers;

import com.hans.bookstoreapi.model.entity.Purchase;
import com.hans.bookstoreapi.services.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/purchases")
@AllArgsConstructor
@RestController
public class PurchaseController {

    private PurchaseService purchaseService;

    @PostMapping
    public Purchase create(@RequestBody List<Integer> bookIds) {
        return purchaseService.create(bookIds);
    }

    @GetMapping("/{id}")
    public Purchase get(@PathVariable Integer id) {
        return purchaseService.findById(id);
    }

    @GetMapping("/purchases/{purchasesId}/items/{itemId}/book/file")
    Resource downloadBookFromPurchaseItem(
            @PathVariable Integer purchasesId,
            @PathVariable Integer itemId
    ){
        return purchaseService.getItemResource(purchasesId, itemId);
    }
}
