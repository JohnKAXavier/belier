package com.belier.controller;

import com.belier.domain.Piece;
import com.belier.domain.PieceSale;
import com.belier.dto.*;
import com.belier.service.PieceSaleService;
import com.belier.service.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pieces")
public class PieceController {

    @Autowired
    PieceService pieceService;

    @Autowired
    PieceSaleService pieceSaleService;

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        Piece piece = pieceService.getById(id);
        return ResponseEntity.ok(piece);
    }

    @GetMapping
    public ResponseEntity<PageablePieceDto> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size){

        PageablePieceDto dto = pieceService.getAllPageable(page, size);
        if(dto.getPieces().isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Validated Piece piece){
        pieceService.create(piece);
        return ResponseEntity.ok("Saved");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody @Validated Piece piece){
        pieceService.update(id, piece);
        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        pieceService.delete(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/sales-by-month")
    public ResponseEntity getSalesByMonth(){
        List<SalesByMonthDto> salesByMonthDtos = pieceSaleService.getSalesByMonth();
        return ResponseEntity.ok(salesByMonthDtos);
    }

    @GetMapping("/last-few-transactions")
    public ResponseEntity getLastFewTransactions(){
        List<LastFewTransactionsDto> lastFewTransactionsDtos = pieceSaleService.getLastFewTransactions();
        return ResponseEntity.ok(lastFewTransactionsDtos);
    }

    @GetMapping("/best-seller")
    public ResponseEntity getBestSellerPiece(){
        List<BestSellerPieceDto> bestSellerPieceDtos = pieceSaleService.getBestSellerPiece();
        return ResponseEntity.ok(bestSellerPieceDtos);
    }


}
