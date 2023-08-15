package com.belier.dto;

import com.belier.domain.PieceType;
import com.belier.domain.TransactionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PieceDto {

    private String name;
    private PieceType pieceType;
    private Double price;
    private Double factoryPrice;
    private Double netValue;
    private TransactionType transactionType;
    private byte[] photo;

}
