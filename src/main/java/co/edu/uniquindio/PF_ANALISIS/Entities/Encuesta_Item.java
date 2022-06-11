package co.edu.uniquindio.PF_ANALISIS.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="ENCUESTA_ITEM")
@Getter
@Setter
public class Encuesta_Item {
    @Id
    @Column(name="id_encuesta_item")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEncuestaItem;

    @ManyToOne
    private Calificacion calificacion;

    @ManyToOne
    private Encuesta encuesta;

    @ManyToOne
    private Item item;

    public Encuesta_Item() {
    }

    public Encuesta_Item(Calificacion calificacion, Encuesta encuesta, Item item) {
        this.calificacion = calificacion;
        this.encuesta = encuesta;
        this.item = item;
    }
}
