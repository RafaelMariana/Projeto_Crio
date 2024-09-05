package controler;

import domain.usuario.Usuario;
import domain.usuario.UsuarioRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        Usuario newUsuario = this.usuarioService.createususario(ususarioRequestDTO);
        return ResponseEntity.ok(newUsuario);



    }
}
