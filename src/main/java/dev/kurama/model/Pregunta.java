package dev.kurama.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Pregunta {

    private String pregunta;
    private ArrayList<String> opciones = new ArrayList<>();

    public Pregunta() {
    }

    public Pregunta(String pregunta, String... opciones) {
        this.pregunta = pregunta;
        this.opciones.addAll(Arrays.asList(opciones));
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public ArrayList<String> getOpciones() {
        return opciones;
    }

}
