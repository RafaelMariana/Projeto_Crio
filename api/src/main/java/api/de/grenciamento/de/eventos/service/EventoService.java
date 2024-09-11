package api.de.grenciamento.de.eventos.service;


import api.de.grenciamento.de.eventos.domain.eventos.EventoRequestDTO;
import api.de.grenciamento.de.eventos.domain.eventos.Evento;
import api.de.grenciamento.de.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
    public class EventoService {
        @Autowired
        private EventoRepository eventoRepository;

        public Evento createEvento(EventoRequestDTO data){
            Evento newEvento = new Evento();
            newEvento.setTitulo(data.titulo());
            newEvento.setDescricao(data.descricao());
            newEvento.setInicio(data.inicio());
            newEvento.setFim(data.fim());
            newEvento.setLocal(data.local());
            newEvento.setPrivado(data.privado());
            newEvento.setUsuario(data.usuario());
            eventoRepository.save(newEvento);
            return newEvento;

        }
    public List<Evento> getAllUsers() {
        return eventoRepository.findAll();
    }

    public Evento getUserById(UUID id) {
        return eventoRepository.findById(id).orElseThrow(()-> new RuntimeException("Evento não encontrado."));
    }

    public Evento updateUser(UUID id, EventoRequestDTO eventoRequestDTO) {
        Evento updateEvento = getUserById(id);
        updateEvento.setTitulo(eventoRequestDTO.titulo());
        updateEvento.setDescricao(eventoRequestDTO.descricao());
        updateEvento.setInicio(eventoRequestDTO.inicio());
        updateEvento.setFim(eventoRequestDTO.fim());
        updateEvento.setUsuario(eventoRequestDTO.usuario());
        updateEvento.setPrivado(eventoRequestDTO.privado());


        return eventoRepository.save(updateEvento);

    }
    public void deleteEvento(UUID id){
        Evento evento = getUserById(id);
        eventoRepository.delete(evento);
    }
}




