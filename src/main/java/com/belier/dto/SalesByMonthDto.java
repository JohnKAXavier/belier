package com.belier.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class SalesByMonthDto {

    private Double monthValue;
    private Integer month;
}
