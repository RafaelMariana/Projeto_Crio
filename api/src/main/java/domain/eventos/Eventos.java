package domain.eventos;

import domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Table(name="eventos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Eventos {
    @Id
    @GeneratedValue
    private UUID id;
    private String titulo;
    private String descricao;
    private LocalTime inicio;
    private LocalTime fim;
    private String local;
    private int publico_alvo;
    private boolean privado;
    private boolean organizador;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
