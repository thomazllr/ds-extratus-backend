package com.thomazllr.ds_extratus.repository;

import com.thomazllr.ds_extratus.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCpf(String cpf);


}
