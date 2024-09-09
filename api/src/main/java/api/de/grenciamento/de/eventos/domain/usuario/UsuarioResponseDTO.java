package api.de.grenciamento.de.eventos.domain.usuario;

public record UsuarioResponseDTO(
        String nomeCompleto,
        String  email,
        String senha,
        int tipo
) {
}
