package co.edu.uniquindio.PF_ANALISIS.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ITEM")
@Getter
@Setter
public class Item {

    @Id
    @Column(name = "id_item")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idItem;

    @Column(name = "enunciado", nullable = false, length = 300)
    private String enunciado;

    @OneToMany(mappedBy = "item")
    private List<Encuesta_Item> encuestaItems;

    public Item() {
    }

    public Item(int idItem, String enunciado) {
        this.enunciado = enunciado;
        this.idItem = idItem;
    }
}
