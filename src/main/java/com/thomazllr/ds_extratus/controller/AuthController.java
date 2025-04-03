package com.thomazllr.ds_extratus.controller;

import com.thomazllr.ds_extratus.dtos.usuario.LoginDto;
import com.thomazllr.ds_extratus.dtos.usuario.UsuarioRequest;
import com.thomazllr.ds_extratus.dtos.usuario.UsuarioResponse;
import com.thomazllr.ds_extratus.model.Usuario;
import com.thomazllr.ds_extratus.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody UsuarioRequest usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.create(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponse> login(@RequestBody LoginDto login) {
        return ResponseEntity.ok(usuarioService.login(login));
    }
}
