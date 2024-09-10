package api.de.grenciamento.de.eventos.controler;

import api.de.grenciamento.de.eventos.domain.usuario.Usuario;
import api.de.grenciamento.de.eventos.domain.usuario.UsuarioRequestDTO;
import api.de.grenciamento.de.eventos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioControler {
    //CRUD CREATE READ DELETE
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity <Usuario>create(
            @RequestParam("nomecompleto") String nomeCompleto,
            @RequestParam("email") String email,
            @RequestParam("senha") String senha,
            @RequestParam("tipo") int tipo){
        UsuarioRequestDTO usuarioRequestDTO = new UsuarioRequestDTO(nomeCompleto,email,senha,tipo);
        Usuario newUsuario = this.usuarioService.createUsuario(usuarioRequestDTO);
        return ResponseEntity.ok(newUsuario);

    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers(){
         List<Usuario> usuarios = this.usuarioService.getAllUsers();
         //retorna a lista com todos os usuários
         return ResponseEntity.ok(usuarios);

    }
    @GetMapping("/{id}")
        public ResponseEntity<Usuario> getUserById(@PathVariable("id") UUID id){
            Usuario usuario = this.usuarioService.getUserById(id);
            return ResponseEntity.ok(usuario);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Usuario> updateUser(@PathVariable("id")UUID id,UsuarioRequestDTO usuarioRequestDTO){
        Usuario updateUsuario = this.usuarioService.updateUser(id,usuarioRequestDTO);
        return ResponseEntity.ok(updateUsuario);


        }

    }


