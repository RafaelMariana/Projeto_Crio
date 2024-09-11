package api.de.grenciamento.de.eventos.repository;

import api.de.grenciamento.de.eventos.domain.eventos.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository<Evento, UUID> {
    //findEntosByTitle() implementar
    //findEventosByDate()

}
