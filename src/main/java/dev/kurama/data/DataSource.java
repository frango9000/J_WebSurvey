package dev.kurama.data;

import dev.kurama.model.Pregunta;
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

    private static Pregunta[] preguntas = {
        new Pregunta("Pregunta 1", "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", "Opcion 5"),
        new Pregunta("Pregunta 1", "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4"),
        new Pregunta("Pregunta 1", "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", "Opcion 5", "Opcion 6"),
        new Pregunta("Pregunta 1", "Opcion 1", "Opcion 2"),
        new Pregunta("Pregunta 1", "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4"),
        new Pregunta("Pregunta 1", "Opcion 1", "Opcion 2", "Opcion 3")
    };

    public static Pregunta[] getPreguntas() {
        return preguntas;
    }
}
