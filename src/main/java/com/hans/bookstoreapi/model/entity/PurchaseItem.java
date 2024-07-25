package com.hans.bookstoreapi.model.entity;

import jakarta.persistence.*;

import lombok.Data;

import java.util.List;

@Data
@Entity
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float price;

    @Column(name = "down_ava")
    private Integer downloadAvailable;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "purchase_id", referencedColumnName = "id")
    private Purchase purchase;

}
