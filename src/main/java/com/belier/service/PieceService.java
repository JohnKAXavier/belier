package com.belier.service;

import com.belier.domain.Piece;
import com.belier.repository.PieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PieceService {

    @Autowired
    PieceRepository repository;

    public List<Piece> getAll(){
        return repository.findAll();
    }

    public void create(Piece piece){
        repository.save(piece);
    }

    public Piece getById(Long id){
        return repository.findById(id).orElseGet(null);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void update(Long id, Piece updatePiece){
        Piece piece = repository.findById(id).orElseGet(null);

        piece.setName(updatePiece.getName());
        piece.setFactoryPrice(updatePiece.getFactoryPrice());
        piece.setNetValue(updatePiece.getNetValue());
        piece.setTransactionType(updatePiece.getTransactionType());
        piece.setPieceType(updatePiece.getPieceType());

        repository.save(piece);
    }
}
