package co.edu.uniquindio.PF_ANALISIS.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="CALIFICACION")
@Getter
@Setter
public class Calificacion {

    @Id
    @Column(name = "id_calificacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCalificacion;

    @Column(name = "score")
    private Integer score;

    @OneToMany(mappedBy = "calificacion")
    private List<EncuestaItem> encuestaItems;

    public Calificacion() {
    }

    public Calificacion(Integer idCalificacion, Integer score) {
        this.score = score;
        this.idCalificacion = idCalificacion;
    }
}
