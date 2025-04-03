package com.thomazllr.ds_extratus.service;

import com.thomazllr.ds_extratus.dto.cliente.ClienteRequest;
import com.thomazllr.ds_extratus.model.Cliente;
import com.thomazllr.ds_extratus.model.Profissao;
import com.thomazllr.ds_extratus.repository.ClienteRepository;
import com.thomazllr.ds_extratus.repository.ProfissaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ProfissaoRepository profissaoRepository;

    public Cliente create(ClienteRequest request) {
        List<Profissao> profissoes = profissaoRepository.findAllById(request.profissoes());
        var cliente = Cliente
                .builder()
                .nome(request.nome())
                .cpf(request.cpf())
                .telefone(request.telefone())
                .profissoes(profissoes)
                .dataNascimento(request.dataNascimento())
                .email(request.email())
                .build();
        return repository.save(cliente);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

}
