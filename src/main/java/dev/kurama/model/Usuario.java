package dev.kurama.model;

import java.util.Objects;

public class Usuario {

    private long id;
    private String email;
    private String pass;

    private EncuestaBean encuesta;

    public Usuario() {
    }

    public Usuario(long id, String email, String pass) {
        this.id    = id;
        this.email = email;
        this.pass  = pass;
    }

    public Usuario(long id, String email, String pass, EncuestaBean encuesta) {
        this.id       = id;
        this.email    = email;
        this.pass     = pass;
        this.encuesta = encuesta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public EncuestaBean getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(EncuestaBean encuesta) {
        this.encuesta = encuesta;
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
