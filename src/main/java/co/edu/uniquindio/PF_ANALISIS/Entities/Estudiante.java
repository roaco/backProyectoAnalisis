package co.edu.uniquindio.PF_ANALISIS.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ESTUDIANTE")
@Setter
@Getter
public class Estudiante {

    @Id
    @Column(name="id_codigo")
    private Integer codigo;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "email", nullable = false, length = 150, unique = true)
    private String email;

    @ManyToOne
    private Encuesta encuesta;

    @ManyToOne
    private Test test;

    public Estudiante() {
    }

    public Estudiante(Integer codigo, String nombre, String email) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
    }
}
