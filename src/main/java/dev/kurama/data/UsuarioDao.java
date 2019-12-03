package dev.kurama.data;

import dev.kurama.model.Usuario;
import java.util.ArrayList;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioDao {

    public static Optional<Usuario> getUsuario(String email, String pass) {
        Query query = ConnectionFactory.getEntityManager()
                                       .createNamedQuery("Usuario.findByAuth")
                                       .setParameter("email", email)
                                       .setParameter("pass", pass);
        try {
            Usuario usuario = (Usuario) query.getSingleResult();
            return Optional.of(usuario);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static Optional<Usuario> getUsuario(int id) {
        return getUsuario(ConnectionFactory.getEntityManager(), id);
    }

    public static Optional<Usuario> getUsuario(EntityManager em, int id) {
        Query query = em.createNamedQuery("Usuario.findById")
                        .setParameter("id", id);
        try {
            Usuario usuario = (Usuario) query.getSingleResult();
            return Optional.of(usuario);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static ArrayList<Usuario> getUsuarios() {
        Query query = ConnectionFactory.getEntityManager()
                                       .createNamedQuery("Usuario.findAll");
        return (ArrayList<Usuario>) query.getResultList();
    }

}
