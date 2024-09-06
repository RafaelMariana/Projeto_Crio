package api.de.grenciamento.de.eventos.repository;

import api.de.grenciamento.de.eventos.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

}
