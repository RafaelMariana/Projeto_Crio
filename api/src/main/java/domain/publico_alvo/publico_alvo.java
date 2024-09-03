package domain.publico_alvo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table
@Entity
public class publico_alvo {
    @Id
    @GeneratedValue
    private UUID id;
    private String descricao;
}
