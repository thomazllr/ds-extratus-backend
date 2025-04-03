package com.thomazllr.ds_extratus.dto.usuario;

import org.hibernate.validator.constraints.br.CPF;

public record LoginDto(@CPF(message = "Por favor, insira um cpf válido")String cpf, String senha) {
}
