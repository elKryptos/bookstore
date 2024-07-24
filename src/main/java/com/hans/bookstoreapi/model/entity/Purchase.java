package com.hans.bookstoreapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Entity
public class Purchase {
    @Id
    @GeneratedValue
    private Integer id;
    private Float total;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @ManyToOne
    @JoinColumn(name = "custormer_id", referencedColumnName = "id")
    private User customer;

    public enum PaymentStatus{
        PENDING,
        PAID
    }
}
