package service;

import domain.usuario.Usuario;
import domain.usuario.UsuarioRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import repository.UsuarioRepository;

public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUsuario(UsuarioRequestDTO data){
        Usuario newUsuario = new Usuario();
        newUsuario.setNomeCompleto(data.nomeCompleto());
        newUsuario.setEmail(data.email());
        newUsuario.setSenha(data.senha());
        newUsuario.setTipo(data.tipo());
        usuarioRepository.save(newUsuario);
        return newUsuario;

    }
}
