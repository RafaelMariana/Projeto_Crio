package api.de.grenciamento.de.eventos.domain.eventos;

import api.de.grenciamento.de.eventos.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;



public record EventoResponseDTO(
    UUID id,
    String titulo,
    String descricao,
    LocalDateTime inicio,
    LocalDateTime fim,
    String local,
    boolean privado,

    Usuario usuario

){

}

