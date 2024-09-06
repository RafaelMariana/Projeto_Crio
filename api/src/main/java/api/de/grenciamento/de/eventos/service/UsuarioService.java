package api.de.grenciamento.de.eventos.service;

import api.de.grenciamento.de.eventos.domain.usuario.Usuario;
import api.de.grenciamento.de.eventos.domain.usuario.UsuarioRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.de.grenciamento.de.eventos.repository.UsuarioRepository;
@Service
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
