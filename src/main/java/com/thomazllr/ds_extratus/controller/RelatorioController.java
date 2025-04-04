package com.thomazllr.ds_extratus.controller;

import com.thomazllr.ds_extratus.dto.doenca.cliente.DoencaClienteResponse;
import com.thomazllr.ds_extratus.model.Cliente;
import com.thomazllr.ds_extratus.service.ClienteService;
import com.thomazllr.ds_extratus.service.DoencaClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/relatorio")
public class RelatorioController {

    private final ClienteService service;

    @GetMapping
    public ResponseEntity<List<DoencaClienteResponse>> relatorio(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) String doenca
    ) {
        return ResponseEntity.ok(service.search(nome, cpf, doenca));
    }
}
