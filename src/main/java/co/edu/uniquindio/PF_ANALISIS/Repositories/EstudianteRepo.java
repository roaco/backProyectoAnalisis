package co.edu.uniquindio.PF_ANALISIS.Repositories;

import co.edu.uniquindio.PF_ANALISIS.DTO.EstudianteDTO;
import co.edu.uniquindio.PF_ANALISIS.Entities.Estudiante;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer> {
    @Query(value = "select nombre, puntaje calificacion"+
            "from"+
            "ESTUDIANTE join TEST on ESTUDIANTE.test_id_test = test.id_test"+
            "order by 2 desc")
    List<EstudianteDTO> getEstudiantesPuntaje();

}

