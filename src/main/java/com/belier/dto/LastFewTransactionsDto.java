package com.belier.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LastFewTransactionsDto {

    private byte[] photo;
    private String name;
    private Double price;
}
