package co.edu.uniquindio.PF_ANALISIS.Repositories;

import co.edu.uniquindio.PF_ANALISIS.Entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EstudianteRepo extends JpaRepository<Estudiante, Integer> {

    /**
     * Obtiene todos los estudiantes ordenandolos segun la calificacion del test.
     */
    @Query(value = "SELECT nombre, id_estudiante, sum(valoracion) nota FROM respuesta join estudiante on estudiante.codigo = respuesta.id_estudiante group by id_estudiante order by 2 desc", nativeQuery = true)
    List<Object[]> getEstudiantesPuntaje();

    @Query(value = "SELECT nombre, codigo, enunciado, valoracion FROM respuesta R join estudiante E on E.codigo = R.id_estudiante join pregunta P on P.id_pregunta = R.id_pregunta where codigo = ?", nativeQuery = true)
    List<Object[]> getResultadosTest(Integer codigo);

}
