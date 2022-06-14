package co.edu.uniquindio.PF_ANALISIS.Entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "OPINION")
@Getter
@Setter
public class OpinionUsuario {

    @Id
    @Column(name = "id_opinion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOpinion;

    @Column (name = "id_item")
    private int idPreguntaTest;

    @Column (name = "id_estudiante")
    private int idUsuario;

    @Column (name = "valoracion", nullable = false)
    private int valoracion;

    public OpinionUsuario() {
    }

    public OpinionUsuario(int idPreguntaTest, int idUsuario, int valoracion) {
        this.idPreguntaTest = idPreguntaTest;
        this.idUsuario = idUsuario;
        this.valoracion = valoracion;
    }
}