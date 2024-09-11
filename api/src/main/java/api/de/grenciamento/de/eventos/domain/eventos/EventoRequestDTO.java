package api.de.grenciamento.de.eventos.domain.eventos;

import api.de.grenciamento.de.eventos.domain.usuario.Usuario;

import java.time.LocalDateTime;



    public record EventoRequestDTO(

             String titulo,
             String descricao,
             LocalDateTime inicio,
             LocalDateTime fim,
             String local,

             boolean privado,

             Usuario usuario

    ){

    }
