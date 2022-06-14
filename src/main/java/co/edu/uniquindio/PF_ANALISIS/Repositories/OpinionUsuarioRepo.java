package co.edu.uniquindio.PF_ANALISIS.Repositories;

import co.edu.uniquindio.PF_ANALISIS.Entities.OpinionUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpinionUsuarioRepo extends JpaRepository<OpinionUsuario, Integer> {

    @Query(value = "select i.enunciado, avg(valoracion) Promedio_Global from opinion o join item i on i.id_item = o.id_item group by i.enunciado order by 1 ", nativeQuery = true)
    List<Object[]> getPromedioOpinion();

}
