package com.thomazllr.ds_extratus.service;

import com.thomazllr.ds_extratus.model.Profissao;
import com.thomazllr.ds_extratus.repository.ProfissaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfissaoService {

    private final ProfissaoRepository repository;

    public List<Profissao> findAll() {
        return repository.findAll();
    }

}
