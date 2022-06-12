package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.DTO.ResultadoDTO;
import co.edu.uniquindio.PF_ANALISIS.Entities.Test;
import co.edu.uniquindio.PF_ANALISIS.Repositories.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepo testRepo;

    @Transactional
    public ResultadoDTO getAllTests(Integer idTest) {
        return testRepo.getResultadoTest(idTest);
    }

    @Transactional
    public List<Test> getAllTests() {
        return testRepo.findAll();
    }

    @Transactional
    public boolean deleteTest(Integer idTest) {
        if (testRepo.findById(idTest) == null) {
            return false;
        }
        testRepo.deleteById(idTest);
        return true;
    }

    @Transactional
    public boolean crearTest(Test test) {
        if (testRepo.findById(test.getIdTest()) != null) {
            return false;
        }
        testRepo.save(test);
        return true;
    }


}
