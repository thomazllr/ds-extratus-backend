package com.thomazllr.ds_extratus.service;

import com.thomazllr.ds_extratus.dto.cliente.ClienteRequest;
import com.thomazllr.ds_extratus.dto.doenca.cliente.DoencaClienteResponse;
import com.thomazllr.ds_extratus.model.Cliente;
import com.thomazllr.ds_extratus.model.DoencaCliente;
import com.thomazllr.ds_extratus.model.Profissao;
import com.thomazllr.ds_extratus.repository.ClienteRepository;
import com.thomazllr.ds_extratus.repository.DoencaClienteRepository;
import com.thomazllr.ds_extratus.repository.ProfissaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import static com.thomazllr.ds_extratus.repository.specs.ClienteSpecification.*;


@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ProfissaoRepository profissaoRepository;
    private final DoencaClienteRepository doencaClienteRepository;

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

    public Cliente findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("nao achado!"));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }


    public List<DoencaClienteResponse>  search(String nome, String cpf, String doenca) {
        Specification<Cliente> specification = Specification.where((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());

        if (nome != null) {
            specification = specification.and(nomeContains(nome));
        }

        if (cpf != null) {
            specification = specification.and(cpfEquals(cpf));
        }

        if (doenca != null) {
            specification = specification.and(temDoenca(doenca));
        }

        List<Cliente> clientes = repository.findAll(specification);

        return clientes.stream().map(cliente -> {
            List<DoencaCliente> doencasDoCliente = doencaClienteRepository.findByCliente(cliente);
            return DoencaClienteResponse.toResponse(cliente, doencasDoCliente);
        }).toList();
    }

}
