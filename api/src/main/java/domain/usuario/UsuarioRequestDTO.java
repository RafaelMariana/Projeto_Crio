package domain.usuario;

public record UsuarioRequestDTO(
        String nomeCompleto,
        String  email,
        String senha,
        int tipo
) {
}
