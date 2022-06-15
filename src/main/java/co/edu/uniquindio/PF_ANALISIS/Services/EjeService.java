package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.Repositories.EjeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;

@Service
public class EjeService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private EjeRepo ejeRepo;

    @Transactional
    public Object[] findPuntoIdPregunta(Integer idPregunta) {
        return ejeRepo.findPuntoIdPregunta(idPregunta);
    }

}
