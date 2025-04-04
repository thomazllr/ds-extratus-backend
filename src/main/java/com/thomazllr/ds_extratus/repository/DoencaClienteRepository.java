package com.thomazllr.ds_extratus.repository;

import com.thomazllr.ds_extratus.model.Cliente;
import com.thomazllr.ds_extratus.model.DoencaCliente;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DoencaClienteRepository extends JpaRepository<DoencaCliente, Long>, JpaSpecificationExecutor<DoencaCliente> {

    List<DoencaCliente> findByCliente(Cliente cliente);
}
