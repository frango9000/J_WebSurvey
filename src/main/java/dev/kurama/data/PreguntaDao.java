package dev.kurama.data;

import dev.kurama.model.Pregunta;
import java.util.ArrayList;
import java.util.Optional;
import javax.persistence.Query;

public class PreguntaDao {


    public static Optional<Pregunta> getPregunta(int id) {
        Query query = ConnectionFactory.getEntityManager()
                                       .createNamedQuery("Pregunta.findById")
                                       .setParameter("id", id);
        try {
            Pregunta pre = (Pregunta) query.getSingleResult();
            return Optional.of(pre);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static ArrayList<Pregunta> getPreguntas() {
        Query query = ConnectionFactory.getEntityManager()
                                       .createNamedQuery("Pregunta.findAll");
        return (ArrayList<Pregunta>) query.getResultList();
    }

}
