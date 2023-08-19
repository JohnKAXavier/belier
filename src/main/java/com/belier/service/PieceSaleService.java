package com.belier.service;

import com.belier.domain.Piece;
import com.belier.domain.PieceSale;
import com.belier.dto.*;
import com.belier.mapper.PieceSaleMapper;
import com.belier.repository.PieceSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PieceSaleService {

    @Autowired
    PieceSaleRepository repository;

    public List<PieceSale> getAll(){
        return repository.findAll();
    }

    public PageablePieceSaleDto getAllPageable(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<PieceSale> pieceSalePage = repository.findAll(pageable);

        return PieceSaleMapper.toPageablePieceSaleDto(pieceSalePage.getContent(), pieceSalePage.getNumber(), pieceSalePage.getTotalElements(), pieceSalePage.getTotalPages());
    }

    public void create(PieceSale pieceSale){
        repository.save(pieceSale);
    }

    public PieceSale getById(Long id){
        return repository.findById(id).orElseGet(null);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void update(Long id, PieceSale updatePieceSale){
        PieceSale pieceSale = repository.findById(id).orElseGet(null);
        pieceSale.setPiece(updatePieceSale.getPiece());
        pieceSale.setQuantity(updatePieceSale.getQuantity());
        pieceSale.setSoldAt(updatePieceSale.getSoldAt());
        pieceSale.setTransactionType(updatePieceSale.getTransactionType());
        repository.save(pieceSale);
    }

    public List<BestSellerPieceDto> getBestSellerPiece(){
        return repository.getBestSellerPieceDto();
    }

    public List<SalesByMonthDto> getSalesByMonth(){
        return repository.getSalesByMonth();
    }

    public List<LastFewTransactionsDto> getLastFewTransactions(){
        return repository.getLastFewTransactions();
    }


}
