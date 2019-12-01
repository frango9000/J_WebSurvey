package dev.kurama.model;

import java.util.ArrayList;

public class EncuestaBean {

    private long id;
    private ArrayList<Integer> respuestas = new ArrayList<>();

    public EncuestaBean() {
    }

    public EncuestaBean(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Integer> getRespuestas() {
        return respuestas;
    }
}
