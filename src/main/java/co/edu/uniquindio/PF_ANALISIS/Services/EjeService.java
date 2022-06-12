package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.Entities.Eje;
import co.edu.uniquindio.PF_ANALISIS.Repositories.EjeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EjeService {

    @Autowired
    private EjeRepo ejeRepo;

    @Transactional
    public List<Eje> getAllEjes() {
        return ejeRepo.findAll();
    }

    @Transactional
    public boolean crearEje(Eje eje) {
        if (ejeRepo.findById(eje.getIdEje()) != null) {
            return false;
        }
        ejeRepo.save(eje);
        return true;
    }

    @Transactional
    public boolean eliminarEje(Integer idEje) {
        if (ejeRepo.findById(idEje) == null) {
            return false;
        }
        ejeRepo.deleteById(idEje);
        return true;
    }


}
