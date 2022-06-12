package co.edu.uniquindio.PF_ANALISIS.Repositories;

import co.edu.uniquindio.PF_ANALISIS.DTO.ItemDTO;
import co.edu.uniquindio.PF_ANALISIS.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Integer> {
    @Query(value = "select item_id_item opinion, avg(calificacion.score) " +
            "from " +
            "encuesta_item join calificacion on encuesta_item.calificacion_id_calificacion " +
            "= calificacion.id_calificacion" +
            "group by encuesta_item.item_id_item", nativeQuery = true)
    List<ItemDTO> getPromedioOpinion();
}
