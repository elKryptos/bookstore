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
    @Enumerated(EnumType.STRING)
    private paymentStatus paymentStatus;
    private LocalDateTime createdAt;

    public enum paymentStatus{
        PAGATO,
        NONPAGATO;
    }
}
