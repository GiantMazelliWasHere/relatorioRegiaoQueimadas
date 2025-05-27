package br.com.relatorioqueimadasregiao.controllers;

import br.com.relatorioqueimadasregiao.entities.Usuario;
import br.com.relatorioqueimadasregiao.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/v1/usuarios"})
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void criarUsuario(@RequestBody Usuario usuario) {
        this.usuarioService.salvar(usuario);
    }
}
