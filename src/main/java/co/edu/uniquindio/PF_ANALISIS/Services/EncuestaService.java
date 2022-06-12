package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.Entities.Encuesta;
import co.edu.uniquindio.PF_ANALISIS.Repositories.EncuestaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EncuestaService {
    @Autowired
    private EncuestaRepo encuestaRepo;

    @Transactional
    public List<Encuesta> getAllEncuestas() {
        return encuestaRepo.findAll();
    }

    @Transactional
    public boolean deleteEncuesta(Integer idEncuesta) {
        if (encuestaRepo.findById(idEncuesta) == null) {
            return false;
        }
        encuestaRepo.deleteById(idEncuesta);
        return true;
    }

    @Transactional
    public boolean crearEncuesta(Encuesta encuesta) {
        if (encuestaRepo.findById(encuesta.getIdEncuesta()) != null) {
            return false;
        }
        encuestaRepo.save(encuesta);
        return true;
    }
}
