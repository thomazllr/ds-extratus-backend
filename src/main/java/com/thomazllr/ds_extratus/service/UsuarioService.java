package com.thomazllr.ds_extratus.service;

import com.thomazllr.ds_extratus.config.security.TokenService;
import com.thomazllr.ds_extratus.dtos.usuario.LoginDto;
import com.thomazllr.ds_extratus.dtos.usuario.UsuarioRequest;
import com.thomazllr.ds_extratus.dtos.usuario.UsuarioResponse;
import com.thomazllr.ds_extratus.model.Usuario;
import com.thomazllr.ds_extratus.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;


    public UsuarioResponse login(LoginDto request) {
        var usuario = usuarioRepository.findByCpf(request.cpf()).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

        if (!passwordEncoder.matches(request.senha(), usuario.getSenha())) {
            return null;
        }
        String token = tokenService.generateToken(usuario);
        return new UsuarioResponse(usuario.getNome(), usuario.getCpf(), token);

    }

    public Usuario create(UsuarioRequest request) {
        var usuario = usuarioRepository.findByCpf(request.cpf());

        if(usuario.isEmpty()) {
            var usuarioNovo = Usuario
                    .builder()
                    .cpf(request.cpf())
                    .nome(request.nome())
                    .senha(passwordEncoder.encode(request.senha()))
                    .isAdmin(true)
                    .build();
            return usuarioRepository.save(usuarioNovo);
        }

        throw new RuntimeException("Usuario ja cadastrado");
    }


}
