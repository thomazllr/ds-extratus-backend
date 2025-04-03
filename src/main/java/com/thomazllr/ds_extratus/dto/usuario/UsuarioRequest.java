package com.thomazllr.ds_extratus.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;


public record UsuarioRequest(@NotBlank(message = "Por favor insira o nome") String nome,
                             @CPF(message = "Por favor informe um CPF válido") String cpf,
                             @NotBlank(message = "Por favor insira uma senha") @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).{8,50}$",
                                     message = "A senha deve ter entre 8 e 50 caracteres, conter letras e números") String senha) {
}
