package com.thomazllr.ds_extratus.dto.doenca.cliente;

import com.thomazllr.ds_extratus.dto.cliente.ClienteResponse;
import com.thomazllr.ds_extratus.dto.doenca.DoencaResponse;
import com.thomazllr.ds_extratus.model.Cliente;
import com.thomazllr.ds_extratus.model.DoencaCliente;

import java.util.ArrayList;
import java.util.List;

public record DoencaClienteResponse(ClienteResponse client, List<DoencaResponse> doencas) {

    public static DoencaClienteResponse toResponse(DoencaCliente cliente) {
        return new DoencaClienteResponse(ClienteResponse.toResponse(cliente.getCliente()), new ArrayList<>());
    }

    public static DoencaClienteResponse toResponse(Cliente cliente, List<DoencaCliente> doencas) {
        return new DoencaClienteResponse(ClienteResponse.toResponse(cliente), doencas.stream().map(dc -> DoencaResponse.toResponse(dc.getDoenca())).toList());
    }
}
