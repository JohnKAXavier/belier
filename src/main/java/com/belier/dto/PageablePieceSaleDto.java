package com.belier.dto;

import com.belier.domain.PieceSale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageablePieceSaleDto {

    private List<PieceSale> pieceSales;
    private Integer currentPage;
    private Long totalItems;
    private Integer totalPages;
}
