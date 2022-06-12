package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.Entities.PreguntaEje;
import co.edu.uniquindio.PF_ANALISIS.Repositories.PreguntaEjeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PreguntaEjeService {

    @Autowired
    private PreguntaEjeRepo preguntaEjeRepo;

    @Transactional
    public List<PreguntaEje> getAllPreguntas() {
        return preguntaEjeRepo.findAll();
    }

    @Transactional
    public boolean crearPregunta(PreguntaEje pregunta) {
        if (preguntaEjeRepo.findById(pregunta.getIdPreguntaEje()) != null) {
            return false;
        }
        preguntaEjeRepo.save(pregunta);
        return true;
    }

    @Transactional
    public boolean eliminarPregunta(Integer idPreguntaEje) {
        if (preguntaEjeRepo.findById(idPreguntaEje) == null) {
            return false;
        }
        preguntaEjeRepo.deleteById(idPreguntaEje);
        return true;
    }
}
