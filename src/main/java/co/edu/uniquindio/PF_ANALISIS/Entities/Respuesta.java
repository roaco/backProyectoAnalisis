package co.edu.uniquindio.PF_ANALISIS.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RESPUESTA")
@Getter
@Setter
public class Respuesta {

    @Id
    @Column(name = "id_respuesta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRespuesta;

    @Column(name = "instrucciones", nullable = false, length = 100)
    private String instrucciones;

    @Column(name = "puntaje", nullable = false, columnDefinition = "int default 0")
    private Integer puntaje;

    @OneToMany(mappedBy = "respuesta")
    private List<TestPregunta> test_preguntas;

    public Respuesta() {
    }

    public Respuesta(Integer idRespuesta, String instrucciones) {
        this.instrucciones = instrucciones;
        this.idRespuesta = idRespuesta;
    }
}
