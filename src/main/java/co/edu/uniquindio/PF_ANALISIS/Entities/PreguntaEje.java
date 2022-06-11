package co.edu.uniquindio.PF_ANALISIS.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PREGUNTA_EJE")
@Getter
@Setter
public class PreguntaEje {

    @Id
    @Column(name = "id_pregunta_eje")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPreguntaEje;

    @ManyToOne
    private Pregunta pregunta;

    @ManyToOne
    private Eje eje;

    public PreguntaEje() {
    }

    public PreguntaEje(Pregunta pregunta, Eje eje) {
        this.pregunta = pregunta;
        this.eje = eje;
    }
}
