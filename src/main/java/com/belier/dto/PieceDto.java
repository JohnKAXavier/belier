package com.belier.dto;

import com.belier.domain.Piece;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PieceDto {

    private List<Piece> pieces;
    private Integer currentPage;
    private Long totalItems;
    private Integer totalPages;

    public PieceDto toPieceDto(List<Piece> pieces, Integer currentPage, Long totalItems, Integer totalPages){
        PieceDto pieceDto = new PieceDto();
        pieceDto.setPieces(pieces);
        pieceDto.setCurrentPage(currentPage);
        pieceDto.setTotalItems(totalItems);
        pieceDto.setTotalPages(totalPages);
        return pieceDto;
    }

}
