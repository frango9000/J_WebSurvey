package dev.kurama.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
                  @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
                  @NamedQuery(name = "Usuario.findById", query = "SELECT u from Usuario u WHERE u.id = :id"),
                  @NamedQuery(name = "Usuario.findByAuth", query = "SELECT u FROM Usuario u WHERE u.email = :email AND u.pass = :pass")
              })
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false)
    private int id;


    @Column(unique = true, updatable = false, nullable = false)
    private String email;

    @Column(nullable = false)
    private String pass;

    private boolean encuestaRealizada = false;

    @ElementCollection
    @CollectionTable(name = "respuestas", joinColumns = @JoinColumn(name = "user_id"))
    private List<Respuesta> respuestas = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String email, String pass) {
        this.email = email;
        this.pass  = pass;
    }

    public Usuario(int id, String email, String pass) {
        this.id    = id;
        this.email = email;
        this.pass  = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isEncuestaRealizada() {
        return encuestaRealizada;
    }

    public void setEncuestaRealizada(boolean encuestaRealizada) {
        this.encuestaRealizada = encuestaRealizada;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<Integer> respuestas) {
        this.respuestas.clear();
        for (int i = 0; i < respuestas.size(); i++) {
            this.respuestas.add(new Respuesta(i, respuestas.get(i)));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id &&
               Objects.equals(email, usuario.email) &&
               Objects.equals(pass, usuario.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, pass);
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "id=" + id +
               ", email='" + email + '\'' +
               ", pass='" + pass + '\'' +
               '}';
    }
}
