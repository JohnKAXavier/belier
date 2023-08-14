package com.belier.repository;

import com.belier.domain.Piece;
import com.belier.dto.SalesByMonthDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PieceRepository extends JpaRepository<Piece, Long> {

    @Query("SELECT new com.belier.dto.SalesByMonthDto(SUM(p.netValue) as monthValue, MONTH(p.soldAt) as month) from Piece p GROUP BY MONTH(p.soldAt)")
    List<SalesByMonthDto> getSalesByMonth();

}
