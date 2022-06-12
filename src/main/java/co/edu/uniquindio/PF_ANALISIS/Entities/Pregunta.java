package co.edu.uniquindio.PF_ANALISIS.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PREGUNTA")
@Getter
@Setter
public class Pregunta {

    @Id
    @Column(name = "id_pregunta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPregunta;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @OneToMany(mappedBy = "pregunta")
    private List<TestPregunta> test_preguntas;

    @OneToMany(mappedBy = "pregunta")
    private List<PreguntaEje> preguntaEjes;

    public Pregunta() {
    }

    public Pregunta(int idPregunta, String descripcion) {
        this.descripcion = descripcion;
        this.idPregunta = idPregunta;
    }
}
