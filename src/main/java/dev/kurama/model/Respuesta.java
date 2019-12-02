package dev.kurama.model;

import javax.persistence.Embeddable;

@Embeddable
public class Respuesta {

    private int pregunta;
    private int respuesta;

    public Respuesta() {
    }

    public Respuesta(int pregunta, int respuesta) {
        this.pregunta  = pregunta;
        this.respuesta = respuesta;
    }

    public int getPregunta() {
        return pregunta;
    }

    public void setPregunta(int pregunta) {
        this.pregunta = pregunta;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
               "pregunta=" + pregunta +
               ", respuesta=" + respuesta +
               '}';
    }
}
