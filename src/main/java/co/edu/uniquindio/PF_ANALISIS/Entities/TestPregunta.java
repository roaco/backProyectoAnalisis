package co.edu.uniquindio.PF_ANALISIS.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="TEST_PREGUNTA")
@Getter
@Setter
public class TestPregunta {

    @Id
    @Column(name = "id_test_pregunta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTestPregunta;

    @ManyToOne
    private Test test;

    @ManyToOne
    private Respuesta respuesta;

    @ManyToOne
    private Pregunta pregunta;

    public TestPregunta() {
    }

    public TestPregunta(Test test, Respuesta respuesta, Pregunta pregunta) {
        this.test = test;
        this.respuesta = respuesta;
        this.pregunta = pregunta;
    }
}
