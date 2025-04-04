package com.thomazllr.ds_extratus.service;

import com.thomazllr.ds_extratus.dto.doenca.cliente.DoencaClienteRequest;
import com.thomazllr.ds_extratus.dto.doenca.cliente.DoencaClienteResponse;
import com.thomazllr.ds_extratus.model.DoencaCliente;
import com.thomazllr.ds_extratus.repository.DoencaClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.thomazllr.ds_extratus.repository.specs.ClienteSpecification.*;

@Service
@RequiredArgsConstructor
public class DoencaClienteService {

    private final DoencaClienteRepository repository;
    private final ClienteService clienteService;
    private final DoencaService doencaService;

    public List<DoencaCliente> diagnostico(DoencaClienteRequest request) {

        var cliente = clienteService.findById(request.idCliente());
        var doencas = doencaService.findAllById(request.doencas());

        DoencaCliente doencaCliente = new DoencaCliente();
        doencaCliente.setCliente(cliente);

        List<DoencaCliente> resultados = new ArrayList<>();

        for (var doenca : doencas) {
            DoencaCliente dc = new DoencaCliente();
            dc.setCliente(cliente);
            dc.setDoenca(doenca);
            dc.setDataDiagnostico(LocalDate.now());
            resultados.add(repository.save(dc));
        }

        return resultados;
    }

    public DoencaClienteResponse procurarClientes(Long id) {

        var cliente = clienteService.findById(id);

        List<DoencaCliente> doencas = repository.findByCliente(cliente);

        return DoencaClienteResponse.toResponse(cliente, doencas);


    }


}
