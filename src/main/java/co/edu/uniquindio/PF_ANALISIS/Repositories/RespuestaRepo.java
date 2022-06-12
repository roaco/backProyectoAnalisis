package co.edu.uniquindio.PF_ANALISIS.Repositories;

import co.edu.uniquindio.PF_ANALISIS.DTO.RespuestaDTO;
import co.edu.uniquindio.PF_ANALISIS.Entities.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RespuestaRepo extends JpaRepository<Respuesta, Integer> {
    @Query(value = "select test_pregunta.pregunta_id_pregunta question, " +
            "count (R2.puntaje) Respuestas_Correctas," +
            "count (R3.puntaje) Respuestas_Incorrectas" +
            "from " +
            "respuesta R1 left join respuesta R2 " +
            "on R1.id_respuesta = R2.id_respuesta " +
            "and r2.puntaje = '1'" +
            "left join respuesta R3 on r1.id_respuesta = r3.id_respuesta " +
            "and r3.puntaje = '0'" +
            "join test_pregunta " +
            "on r1.id_respuesta = test_pregunta.respuesta_id_respuesta" +
            "group by test_pregunta.pregunta_id_pregunta " +
            "order by 1", nativeQuery = true)
    List<RespuestaDTO> getRespuestasTYF();

}
