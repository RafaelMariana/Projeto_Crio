package api.de.grenciamento.de.eventos.service;

import api.de.grenciamento.de.eventos.domain.usuario.Usuario;
import api.de.grenciamento.de.eventos.domain.usuario.UsuarioRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.de.grenciamento.de.eventos.repository.UsuarioRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public Usuario getUserById(UUID id) {
        return usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuário não encontrado."));
    }

    public Usuario updateUser(UUID id, UsuarioRequestDTO usuarioRequestDTO) {
        Usuario updateUsuario = getUserById(id);
        updateUsuario.setNomeCompleto(usuarioRequestDTO.nomeCompleto());
        updateUsuario.setEmail(usuarioRequestDTO.email());
        updateUsuario.setSenha(usuarioRequestDTO.senha());
        updateUsuario.setTipo(usuarioRequestDTO.tipo());
        updateUsuario.setUpdateAt(LocalDateTime.now());


        return usuarioRepository.save(updateUsuario);

    }
    public void deleteUser(UUID id){
        Usuario usuario = getUserById(id);
        usuarioRepository.delete(usuario);
    }
}
