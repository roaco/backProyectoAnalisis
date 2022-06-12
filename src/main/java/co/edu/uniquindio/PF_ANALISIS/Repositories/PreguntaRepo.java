package co.edu.uniquindio.PF_ANALISIS.Repositories;

import co.edu.uniquindio.PF_ANALISIS.DTO.PreguntaDTO;
import co.edu.uniquindio.PF_ANALISIS.Entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PreguntaRepo extends JpaRepository<Pregunta, Integer> {
    @Query(value = "select test_pregunta.pregunta_id_pregunta as pregunta, " +
            "avg(respuesta.puntaje) as promedio " +
            "from " +
            "respuesta join test_pregunta on respuesta.id_respuesta = " +
            "test_pregunta.respuesta_id_respuesta " +
            "group by test_pregunta.pregunta_id_pregunta" +
            "order by 1", nativeQuery = true)
    List<PreguntaDTO> getPreguntasPromedio();
}
