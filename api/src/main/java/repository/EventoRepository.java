package repository;

import domain.eventos.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository<Eventos, UUID> {
    //findEntosByTitle() implementar
    //findEventosByDate()

}
