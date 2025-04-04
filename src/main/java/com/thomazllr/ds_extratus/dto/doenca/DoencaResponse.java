package com.thomazllr.ds_extratus.dto.doenca;

import com.thomazllr.ds_extratus.model.Doenca;

public record DoencaResponse(Long id, String nome, String descricao) {

    public static DoencaResponse toResponse(Doenca doenca) {
        return new DoencaResponse(doenca.getId(), doenca.getNome(), doenca.getDescricao());
    }
}
