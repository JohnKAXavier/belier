package com.belier.repository;

import com.belier.domain.PieceSale;
import com.belier.dto.BestSellerPieceDto;
import com.belier.dto.LastFewTransactionsDto;
import com.belier.dto.SalesByMonthDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PieceSaleRepository extends JpaRepository<PieceSale, Long> {

    @Query("SELECT new com.belier.dto.BestSellerPieceDto(p.piece.name as name, p.quantity as quantity) from PieceSale p GROUP BY p.piece")
    List<BestSellerPieceDto> getBestSellerPieceDto();


    @Query("SELECT new com.belier.dto.SalesByMonthDto(SUM(p.piece.netValue) as monthValue, MONTH(p.soldAt) as month) from PieceSale p GROUP BY MONTH(p.soldAt)")
    List<SalesByMonthDto> getSalesByMonth();

    @Query("SELECT new com.belier.dto.LastFewTransactionsDto(p.piece.photo, p.piece.name, p.piece.price) from PieceSale p order by id desc limit 10")
    List<LastFewTransactionsDto> getLastFewTransactions();
}
