package co.edu.uniquindio.PF_ANALISIS.Entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "ITEM")
@Getter
@Setter
public class PreguntaTest {

    @Id
    @Column(name = "id_item")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPreguntaTest;

    @Column (name = "enunciado", nullable = false, length = 250)
    private String descripcion;

}