package dev.kurama;

import dev.kurama.data.ConnectionFactory;
import dev.kurama.data.DataSource;
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
        for (Usuario usuario : DataSource.getUsuarios()) {
            em.merge(usuario);
        }
        for (Pregunta pregunta : DataSource.getPreguntas()) {
            em.merge(pregunta);
        }
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
}
