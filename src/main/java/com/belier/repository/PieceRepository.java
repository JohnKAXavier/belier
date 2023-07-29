package com.belier.repository;

import com.belier.domain.Piece;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PieceRepository extends JpaRepository<Piece, Long> {

    Page<Piece> findAllPageable(Pageable pageable);
}
