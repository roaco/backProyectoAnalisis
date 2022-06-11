package co.edu.uniquindio.PF_ANALISIS.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EJE")
@Getter
@Setter
public class Eje {

    @Id
    @Column(name = "id_eje")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEje;

    @Column(name = "x", columnDefinition = "int default 0")
    private int x;

    @Column(name = "y", columnDefinition = "int default 0")
    private int y;

    @Column(name="desceipcion, nullable=false, length=20")
    private String descripcion;

    @OneToMany(mappedBy = "eje")
    private List<PreguntaEje> preguntaEjes;

    public Eje() {
    }

    public Eje(int x, int y, String descripcion) {
        this.x = x;
        this.y = y;
        this.descripcion = descripcion;
    }
}