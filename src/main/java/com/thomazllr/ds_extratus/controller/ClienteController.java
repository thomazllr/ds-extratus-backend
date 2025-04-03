package com.thomazllr.ds_extratus.controller;

import com.thomazllr.ds_extratus.dto.cliente.ClienteRequest;
import com.thomazllr.ds_extratus.dto.cliente.ClienteResponse;
import com.thomazllr.ds_extratus.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponse> post(@RequestBody ClienteRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteResponse.toResponse(clienteService.create(request)));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> getAll() {
        return ResponseEntity.ok(clienteService.findAll().stream().map(ClienteResponse::toResponse).toList());
    }

}
