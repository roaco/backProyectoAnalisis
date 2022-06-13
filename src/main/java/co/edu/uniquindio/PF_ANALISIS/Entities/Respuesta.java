package co.edu.uniquindio.PF_ANALISIS.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Respuesta")
@Getter
@Setter
public class Respuesta {

    @Id
    @Column(name = "id_Respuesta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;

    @Column(name = "id_Pregunta")
    private int id_Pregunta;


    @Column(name = "idEstudiante")
    private int id_Estudiante;

    @Column(name = "valoracion", nullable = false)
    private int valoracion;

    public Respuesta() {
    }

    public Respuesta(int id_Pregunta, int id_Estudiante, int valoracion) {
        this.id_Pregunta = id_Pregunta;
        this.id_Estudiante = id_Estudiante;
        this.valoracion = valoracion;
    }
}
