package com.thomazllr.ds_extratus.dto.doenca.cliente;

import java.util.List;

public record DoencaClienteRequest(Long idCliente, List<Long> doencas){
}
