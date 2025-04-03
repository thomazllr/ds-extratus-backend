package com.thomazllr.ds_extratus.dto.cliente;

import java.time.LocalDate;
import java.util.List;

public record ClienteRequest(String nome, String cpf, LocalDate dataNascimento, String email, String telefone, List<Long> profissoes) {
}
