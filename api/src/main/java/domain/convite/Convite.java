package domain.convite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table
public class Convite {
    @GeneratedValue
    @Id
    private UUID id;
    private boolean confirmacao_presenca;
}
