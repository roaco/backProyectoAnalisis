package co.edu.uniquindio.PF_ANALISIS.Repositories;

import co.edu.uniquindio.PF_ANALISIS.DTO.EstudianteDTO;
import co.edu.uniquindio.PF_ANALISIS.Entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer> {
    @Query(value = "select nombre, puntaje calificacion" +
            "from" +
            "estudiante join test on estudiante.test_id_test = test.id_test" +
            "order by 2 desc", nativeQuery = true)
    List<EstudianteDTO> getEstudiantesPuntaje();

}

