package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.Entities.Calificacion;
import co.edu.uniquindio.PF_ANALISIS.Repositories.CalificacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepo calificacionRepo;

    @Transactional
    public List<Calificacion> getAllCalificaciones() {
        return calificacionRepo.findAll();
    }

    @Transactional
    public boolean crearCalificacion(Calificacion calificacion) {
        if(calificacionRepo.findById(calificacion.getIdCalificacion()) != null) {
            return false;
        }
        calificacionRepo.save(calificacion);
        return true;
    }

    @Transactional
    public boolean eliminarCalificacion(Integer idCalificacion) {
        if(calificacionRepo.findById(idCalificacion) == null) {
            return false;
        }
        calificacionRepo.deleteById(idCalificacion);
        return true;
    }
}
