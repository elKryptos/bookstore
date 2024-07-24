package com.hans.bookstoreapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class PurchaseItem {
    @Id
    @GeneratedValue
    private Integer id;
    private Float price;
    private Integer download;

    @ManyToOne
    Private
}
