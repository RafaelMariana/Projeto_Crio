package api.de.grenciamento.de.eventos.domain.eventos;

import api.de.grenciamento.de.eventos.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Table(name="eventos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
    @Id
    @GeneratedValue
    private UUID id;
    private String titulo;
    private String descricao;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String local;
    private boolean privado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
