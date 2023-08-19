package com.belier.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class PieceSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Piece piece;

    private Long quantity;

    private LocalDateTime soldAt;

    @ManyToOne
    private TransactionType transactionType;

}
