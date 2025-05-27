package br.com.relatorioqueimadasregiao.services;

import br.com.relatorioqueimadasregiao.entities.Usuario;
import br.com.relatorioqueimadasregiao.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarPorUsername(String username) {
        return (Usuario)this.usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public Usuario salvar(Usuario usuario) {
        return (Usuario)this.usuarioRepository.save(usuario);
    }
}
