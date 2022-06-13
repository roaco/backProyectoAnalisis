package co.edu.uniquindio.PF_ANALISIS.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "Usuario")
@Getter
@Setter
public class Usuario {
    @Id
    @Column(name = "cedula")
    private Integer cedula;
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    public Usuario() {
    }

    public Usuario(Integer cedula, String nombre, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
    }
}
