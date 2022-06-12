package co.edu.uniquindio.PF_ANALISIS.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEST")
@Getter
@Setter
public class Test {

    @Id
    @Column(name = "id_test")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTest;

    @Column(name = "descripcion", nullable = false, length = 150)
    private String descripcion;

    @Column(name = "puntaje", columnDefinition = "int default 0")
    private Integer puntaje;

    @OneToMany(mappedBy = "test")
    private List<TestPregunta> test_preguntas;

    @OneToMany(mappedBy = "test")
    private List<Estudiante> estudiantes;

    public Test() {
    }

    public Test(Integer idTest, String descripcion) {
        this.descripcion = descripcion;
        this.idTest = idTest;
    }
}
