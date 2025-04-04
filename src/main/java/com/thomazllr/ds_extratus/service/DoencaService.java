package com.thomazllr.ds_extratus.service;

import com.thomazllr.ds_extratus.model.Doenca;
import com.thomazllr.ds_extratus.repository.DoencaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoencaService {

    private final DoencaRepository doencaRepository;

    public List<Doenca> findAll() {
        return doencaRepository.findAll();
    }

    public Doenca findById(Long id) {
        return doencaRepository.findById(id).orElseThrow(() -> new RuntimeException("Doenca nao achada!"));
    }

    public List<Doenca> findAllById(List<Long> ids) {
        return doencaRepository.findAllById(ids);
    }
}
