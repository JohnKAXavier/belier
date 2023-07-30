package com.belier.dto;

import com.belier.domain.Piece;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageablePieceDto {

    private List<Piece> pieces;
    private Integer currentPage;
    private Long totalItems;
    private Integer totalPages;
}
