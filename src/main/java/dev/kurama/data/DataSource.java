package dev.kurama.data;

import dev.kurama.model.Usuario;
import java.util.Optional;

public class DataSource {


    private static Usuario[] usuarios = {
        new Usuario(1, "admin", "admin"),
        new Usuario(2, "fran", "fran"),
        new Usuario(3, "emilio", "emilio")
    };

    public static Usuario[] getUsuarios() {
        return usuarios;
    }

    public static Optional<Usuario> getUsuario(String email, String pass) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getPass().equals(pass))
                return Optional.of(usuario);
        }
        return Optional.empty();
    }
}
