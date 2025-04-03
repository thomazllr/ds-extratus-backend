package com.thomazllr.ds_extratus.service;

import com.thomazllr.ds_extratus.model.Produto;
import com.thomazllr.ds_extratus.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public List<Produto> findAll() {
        return repository.findAll();
    }
}
