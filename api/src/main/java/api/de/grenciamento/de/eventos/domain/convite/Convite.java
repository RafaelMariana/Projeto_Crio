package api.de.grenciamento.de.eventos.domain.convite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="convite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Convite {
    @GeneratedValue
    @Id
    private UUID id;
    private boolean confirmacao_presenca;
}
