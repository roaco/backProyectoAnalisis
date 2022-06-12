package co.edu.uniquindio.PF_ANALISIS.Repositories;

import co.edu.uniquindio.PF_ANALISIS.DTO.ResultadoDTO;
import co.edu.uniquindio.PF_ANALISIS.Entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestRepo extends JpaRepository<Test, Integer> {

    @Query(value = "select test_pregunta.test_id_test Test, " +
            "test_pregunta.pregunta_id_pregunta Question, respuesta.puntaje" +
            "from test_pregunta join respuesta on respuesta.id_respuesta = " +
            "test_pregunta.respuesta_id_respuesta" +
            "where test_pregunta.test_id_test = ?", nativeQuery = true)
    ResultadoDTO getResultadoTest(int idTest);
}
