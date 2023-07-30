package com.belier.service;

import com.belier.domain.Piece;
import com.belier.dto.PageablePieceDto;
import com.belier.dto.PieceDto;
import com.belier.mapper.PieceMapper;
import com.belier.repository.PieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PieceService {

    @Autowired
    PieceRepository repository;

    public List<Piece> getAll(){
        return repository.findAll();
    }

    public PageablePieceDto getAllPageable(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Piece> piecePage = repository.findAll(pageable);

        return PieceMapper.toPageablePieceDto(piecePage.getContent(), piecePage.getNumber(), piecePage.getTotalElements(), piecePage.getTotalPages());
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
