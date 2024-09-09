package api.de.grenciamento.de.eventos.controler;

import api.de.grenciamento.de.eventos.domain.usuario.Usuario;
import api.de.grenciamento.de.eventos.domain.usuario.UsuarioRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.de.grenciamento.de.eventos.service.UsuarioService;

import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
        UsuarioRequestDTO ususarioRequestDTO = new UsuarioRequestDTO(nomeCompleto,email,senha,tipo);
        Usuario newUsuario = this.usuarioService.createUsuario(ususarioRequestDTO);
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
            Usuario usuario = this.usuarioService.getUserById();
            return ResponseEntity.ok(usuario);
        }

    }

}
