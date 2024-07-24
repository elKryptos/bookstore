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

    @JoinColumn
    private User customerId;

    public enum PaymentStatus{
        PENDING,
        PAID
    }
}
