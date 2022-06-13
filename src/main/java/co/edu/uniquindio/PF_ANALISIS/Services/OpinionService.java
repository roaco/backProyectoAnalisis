package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.Entities.Opinion;
import co.edu.uniquindio.PF_ANALISIS.Repositories.OpinionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OpinionService {

    @Autowired
    private OpinionRepo opinionRepo;

    @Transactional
    public boolean createOpinion(Opinion opinion) {

        try {
            opinionRepo.save(opinion);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    public List<Object[]> getPromedioOpinion(){
        return opinionRepo.getPromedioOpinion();
    }
}
