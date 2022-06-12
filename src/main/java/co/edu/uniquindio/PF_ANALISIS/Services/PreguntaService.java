package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.DTO.PreguntaDTO;
import co.edu.uniquindio.PF_ANALISIS.Entities.Pregunta;
import co.edu.uniquindio.PF_ANALISIS.Repositories.PreguntaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PreguntaService {
    @Autowired
    private PreguntaRepo preguntaRepo;

    @Transactional
    public List<PreguntaDTO> getAllPreguntas() {
        return preguntaRepo.getPreguntasPromedio();
    }

    @Transactional
    public boolean crearPregunta(Pregunta pregunta) {
        if (preguntaRepo.findById(pregunta.getIdPregunta()) != null) {
            return false;
        }
        preguntaRepo.save(pregunta);
        return true;
    }

    @Transactional
    public boolean eliminarPregunta(Integer idPregunta) {
        if (preguntaRepo.findById(idPregunta) == null) {
            return false;
        }
        preguntaRepo.deleteById(idPregunta);
        return true;
    }


}
