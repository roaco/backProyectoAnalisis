package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.DTO.EstudianteDTO;
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
    public List<EstudianteDTO> getAllEstudiantes() {
        return estudianteRepo.getEstudiantesPuntaje();
    }

    @Transactional
    public boolean crearEstudiante(Estudiante estudiante) {
        if(estudianteRepo.findById(estudiante.getCodigo()) != null) {
            return false;
        }
        estudianteRepo.save(estudiante);
        return true;
    }

    @Transactional
    public boolean eliminarEstudiante(Integer codigo) {
        if (estudianteRepo.findById(codigo) == null) {
            return false;
        }
        estudianteRepo.deleteById(codigo);
        return true;
    }
}
