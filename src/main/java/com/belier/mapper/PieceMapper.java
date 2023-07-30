package com.belier.mapper;

import com.belier.domain.Piece;
import com.belier.dto.PageablePieceDto;
import com.belier.dto.PieceDto;

import java.util.List;

public class PieceMapper {

    public static PageablePieceDto toPageablePieceDto(List<Piece> pieces, Integer currentPage, Long totalItems, Integer totalPages){
        PageablePieceDto pieceDto = new PageablePieceDto();
        pieceDto.setPieces(pieces);
        pieceDto.setCurrentPage(currentPage);
        pieceDto.setTotalItems(totalItems);
        pieceDto.setTotalPages(totalPages);
        return pieceDto;
    }
}
