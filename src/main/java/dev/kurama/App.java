package dev.kurama;

import dev.kurama.data.ConnectionFactory;
import dev.kurama.model.Pregunta;
import dev.kurama.model.Usuario;
import javax.persistence.EntityManager;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        initDb();
    }

    private static void initDb() {
        EntityManager em = ConnectionFactory.getEntityManager();

        em.getTransaction().begin();
        for (Usuario usuario : usuarios) {
            em.merge(usuario);
        }
        for (Pregunta pregunta : preguntas) {
            em.merge(pregunta);
        }
        em.flush();
        em.getTransaction().commit();
        em.close();
    }


    private static Usuario[] usuarios = {
        new Usuario(1, "admin", "admin"),
        new Usuario(2, "a", "a"),
        new Usuario(3, "b", "b"),
        new Usuario(4, "c", "c"),
        new Usuario(5, "d", "d"),
        new Usuario(6, "e", "e")
    };

    public static Pregunta[] preguntas = {
        new Pregunta("Pregunta 1", "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", "Opcion 5"),
        new Pregunta("Pregunta 2", "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4"),
        new Pregunta("Pregunta 3", "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", "Opcion 5", "Opcion 6"),
        new Pregunta("Pregunta 4", "Opcion 1", "Opcion 2"),
        new Pregunta("Pregunta 5", "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4"),
        new Pregunta("Pregunta 6", "Opcion 1", "Opcion 2", "Opcion 3")
    };
}
