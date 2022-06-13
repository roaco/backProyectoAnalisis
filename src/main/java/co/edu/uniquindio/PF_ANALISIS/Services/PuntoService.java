package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.DTO.PuntoDTO;
import co.edu.uniquindio.PF_ANALISIS.Repositories.PuntoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;

@Service
public class PuntoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PuntoRepo puntoRepo;

    @Transactional
    public Object[] findPuntoIdPregunta(Integer idPregunta) {
        return puntoRepo.findPuntoIdPregunta(idPregunta);
    }

}
