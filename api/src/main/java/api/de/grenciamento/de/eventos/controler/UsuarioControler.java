package api.de.grenciamento.de.eventos.controler;

import api.de.grenciamento.de.eventos.domain.usuario.Usuario;
import api.de.grenciamento.de.eventos.domain.usuario.UsuarioRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.de.grenciamento.de.eventos.service.UsuarioService;

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
}
