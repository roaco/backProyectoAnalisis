package co.edu.uniquindio.PF_ANALISIS.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ENCUESTA")
@Getter
@Setter
public class Encuesta {

    @Id
    @Column(name="id_encuesta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEncuesta;

    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;

    @Column(name = "puntaje", columnDefinition = "Decimal(10,0) default 0.00")
    private Double puntaje;

    @OneToMany(mappedBy = "encuesta")
    private List<Encuesta_Item> encuestaItems;

    @OneToMany(mappedBy = "encuesta")
    private List<Estudiante> estudiantes;

    public Encuesta() {
    }

    public Encuesta(Integer idEncuesta, String descripcion) {
        this.descripcion = descripcion;
        this.idEncuesta = idEncuesta;
    }
}
