package com.belier.repository;

import com.belier.domain.Piece;
import com.belier.dto.LastFewTransactionsDto;
import com.belier.dto.SalesByMonthDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PieceRepository extends JpaRepository<Piece, Long> {

//    @Query("SELECT new com.belier.dto.SalesByMonthDto(SUM(p.piece.netValue) as monthValue, MONTH(p.soldAt) as month) from PieceSale p GROUP BY MONTH(p.soldAt)")
//    List<SalesByMonthDto> getSalesByMonth();
//
//    @Query("SELECT new com.belier.dto.LastFewTransactionsDto(p.photo, p.name, p.price) from Piece p order by id desc limit 10")
//    List<LastFewTransactionsDto> getLastFewTransactions();

}
