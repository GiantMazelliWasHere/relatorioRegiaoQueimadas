package br.com.relatorioqueimadasregiao.controllers;

import br.com.relatorioqueimadasregiao.entities.Usuario;
import br.com.relatorioqueimadasregiao.security.JwtUtil;
import br.com.relatorioqueimadasregiao.services.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/v1/auth"})
public class AuthController {
    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        Usuario usuario = usuarioService.buscarPorUsername(username);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return JwtUtil.gerarToken(usuario.getUsername(), usuario.getRole());
        } else {
            return "Credenciais inválidas!";
        }
    }
}
