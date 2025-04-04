package com.thomazllr.ds_extratus.dto.cliente;

import com.thomazllr.ds_extratus.dto.profissao.ProfissaoResponse;
import com.thomazllr.ds_extratus.model.Cliente;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record ClienteResponse(Long id, String nome, String email, LocalDate dataNascimento, String cpf,
                              List<ProfissaoResponse> profissoes) {

    public static ClienteResponse toResponse(Cliente cliente) {
        return ClienteResponse
                .builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .cpf(cliente.getCpf())
                .dataNascimento(cliente.getDataNascimento())
                .profissoes(cliente.getProfissoes().stream().map(ProfissaoResponse::toResponse).toList())
                .build();
    }
}
