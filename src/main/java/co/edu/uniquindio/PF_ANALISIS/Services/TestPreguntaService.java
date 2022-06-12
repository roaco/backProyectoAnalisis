package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.Entities.TestPregunta;
import co.edu.uniquindio.PF_ANALISIS.Repositories.TestPreguntaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestPreguntaService {
    @Autowired
    private TestPreguntaRepo testPreguntaRepo;

    @Transactional
    public List<TestPregunta> getAllPreguntas() {
        return testPreguntaRepo.findAll();
    }

    @Transactional
    public boolean deletePregunta(Integer idPregunta) {
        if (testPreguntaRepo.findById(idPregunta) == null) {
            return false;
        }
        testPreguntaRepo.deleteById(idPregunta);
        return true;
    }

    @Transactional
    public boolean crearPregunta(TestPregunta testPregunta) {
        if (testPreguntaRepo.findById(testPregunta.getIdTestPregunta()) != null) {
            return false;
        }
        testPreguntaRepo.save(testPregunta);
        return true;
    }
}
