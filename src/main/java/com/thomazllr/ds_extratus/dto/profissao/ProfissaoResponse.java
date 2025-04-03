package com.thomazllr.ds_extratus.dto.profissao;

import com.thomazllr.ds_extratus.model.Profissao;

public record ProfissaoResponse(String nome) {

    public static ProfissaoResponse toResponse(Profissao profissao) {
        return new ProfissaoResponse(profissao.getNome());
    }
}
