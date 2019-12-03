package dev.kurama.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                  @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p"),
                  @NamedQuery(name = "Pregunta.findById", query = "SELECT p from Pregunta p WHERE p.id = :id")
              })
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false)
    private int id;

    @Column(nullable = false)
    private String pregunta;


    @ElementCollection
    @CollectionTable(name = "opciones", joinColumns = @JoinColumn(name = "pregunta_id"))
    private List<String> opciones = new ArrayList<>();

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

    public List<String> getOpciones() {
        return opciones;
    }

}
