package com.thomazllr.ds_extratus.controller;

import com.thomazllr.ds_extratus.dto.doenca.cliente.DoencaClienteRequest;
import com.thomazllr.ds_extratus.dto.doenca.cliente.DoencaClienteResponse;
import com.thomazllr.ds_extratus.service.DoencaClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diagnostico")
public class DoencaClienteController {

    private final DoencaClienteService service;

    @PostMapping
    public ResponseEntity<List<DoencaClienteResponse>> create(@RequestBody DoencaClienteRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.diagnostico(request).stream().map(DoencaClienteResponse::toResponse).toList());

    }

    @GetMapping("/{id}")
    public ResponseEntity<DoencaClienteResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.procurarClientes(id));
    }



}
