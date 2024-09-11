package api.de.grenciamento.de.eventos.controler;

import api.de.grenciamento.de.eventos.domain.eventos.EventoRequestDTO;
import api.de.grenciamento.de.eventos.domain.eventos.Evento;
import api.de.grenciamento.de.eventos.domain.usuario.Usuario;
import api.de.grenciamento.de.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;

import java.util.List;
import java.util.UUID;




    @RestController
    @RequestMapping("/api/evento")
    public class EventoControler {
        //CRUD CREATE READ DELETE
        @Autowired
        private EventoService eventoService;

        public EventoControler(EventoService eventoService) {
            this.eventoService = eventoService;
        }

        @PostMapping(consumes = "multipart/form-data")
        public ResponseEntity<Evento> create(
                @RequestParam("titulo") String titulo,
                @RequestParam("descricao") String descricao,
                @RequestParam("inicio") LocalDateTime inicio,
                @RequestParam("fim")LocalDateTime fim,
                @RequestParam("local") String local,
                @RequestParam("privado") boolean privado,
                @RequestParam("usuario") Usuario usuario){


            EventoRequestDTO eventoRequestDTO = new EventoRequestDTO(titulo,descricao,inicio,fim,local,privado,usuario);
            Evento newEvento = this.eventoService.createEvento(eventoRequestDTO);
            return ResponseEntity.ok(newEvento);

        }

        @GetMapping
        public ResponseEntity<List<Evento>> getAllUsers(){
            List<Evento> eventos = this.eventoService.getAllUsers();
            //retorna a lista com todos os usuários
            return ResponseEntity.ok(eventos);

        }
        @GetMapping("/{id}")
        public ResponseEntity<Evento> getUserById(@PathVariable("id") UUID id){
            Evento evento = this.eventoService.getUserById(id);
            return ResponseEntity.ok(evento);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Evento> updateUser(@PathVariable("id")UUID id, EventoRequestDTO eventoRequestDTO){
            Evento updateEvento = this.eventoService.updateUser(id,eventoRequestDTO);
            return ResponseEntity.ok(updateEvento);


        }
        //deletar evento
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable("id")UUID id){
            this.eventoService.deleteEvento(id);
            return ResponseEntity.noContent().build();
        }

    }





