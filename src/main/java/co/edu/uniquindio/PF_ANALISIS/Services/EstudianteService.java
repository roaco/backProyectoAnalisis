package co.edu.uniquindio.PF_ANALISIS.Services;


import co.edu.uniquindio.PF_ANALISIS.Entities.Estudiante;
import co.edu.uniquindio.PF_ANALISIS.Repositories.EstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepo estudianteRepo;


    @Transactional
    public boolean createEstudiante(Estudiante estudiante) {
        if (estudianteRepo.findById(estudiante.getCodigo()) != null) {
            estudianteRepo.save(estudiante);
            return true;
        }
        return false;
    }

    @Transactional
    public List <Object[]> getAllEstudiantesPuntaje() {
        return estudianteRepo.getEstudiantesPuntaje();
    }

    @Transactional
    public List <Object[]> getResultadosTest(Integer id) {
        return estudianteRepo.getResultadosTest(id);
    }

}
