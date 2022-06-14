package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.Entities.OpinionUsuario;
import co.edu.uniquindio.PF_ANALISIS.Repositories.OpinionUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OpinionUsuarioService {

    @Autowired
    private OpinionUsuarioRepo opinionUsuarioRepo;

    @Transactional
    public boolean createOpinion(OpinionUsuario opinionUsuarioTest) {

        try {
            opinionUsuarioRepo.save(opinionUsuarioTest);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    public List<Object[]> getPromedioOpinion(){
        return opinionUsuarioRepo.getPromedioOpinion();
    }
}
