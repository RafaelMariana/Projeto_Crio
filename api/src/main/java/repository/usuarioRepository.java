package repository;

import domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface usuarioRepository extends JpaRepository<Usuario, UUID> {

}
