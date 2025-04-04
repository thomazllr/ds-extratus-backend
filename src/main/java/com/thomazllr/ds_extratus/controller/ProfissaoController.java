package com.thomazllr.ds_extratus.controller;

import com.thomazllr.ds_extratus.dto.profissao.ProfissaoResponse;
import com.thomazllr.ds_extratus.service.ProfissaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profissoes")
public class ProfissaoController {

    private final ProfissaoService service;

    @GetMapping
    public ResponseEntity<List<ProfissaoResponse>> findAll() {
        return ResponseEntity.ok(service.findAll().stream().map(ProfissaoResponse::toResponse).toList());
    }
}
