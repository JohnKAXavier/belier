package com.belier.mapper;

import com.belier.domain.Piece;
import com.belier.domain.PieceSale;
import com.belier.dto.PageablePieceDto;
import com.belier.dto.PageablePieceSaleDto;

import java.util.List;

public class PieceSaleMapper {

    public static PageablePieceSaleDto toPageablePieceSaleDto(List<PieceSale> pieceSales, Integer currentPage, Long totalItems, Integer totalPages){
        PageablePieceSaleDto dto = new PageablePieceSaleDto();
        dto.setPieceSales(pieceSales);
        dto.setCurrentPage(currentPage);
        dto.setTotalItems(totalItems);
        dto.setTotalPages(totalPages);
        return dto;
    }
}
