package com.belier.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Piece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private PieceType pieceType;

    private Double price;

    private Double factoryPrice;

    private Double netValue;

    @OneToOne(cascade = CascadeType.ALL)
    private TransactionType transactionType;

    private LocalDateTime boughtAt;

    private LocalDateTime soldAt;

}
