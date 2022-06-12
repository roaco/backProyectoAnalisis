package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.DTO.RespuestaDTO;
import co.edu.uniquindio.PF_ANALISIS.Entities.Respuesta;
import co.edu.uniquindio.PF_ANALISIS.Repositories.RespuestaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RespuestaService {
    @Autowired
    private RespuestaRepo respuestaRepo;

    @Transactional
    public List<RespuestaDTO> getAllRespuestas() {
        return respuestaRepo.getRespuestasTYF();
    }

    @Transactional
    public boolean crearRespuesta(Respuesta respuesta) {
        if (respuestaRepo.findById(respuesta.getIdRespuesta()) != null) {
            return false;
        }
        respuestaRepo.save(respuesta);
        return true;
    }

    @Transactional
    public boolean eliminarRespuesta(Integer idRespuesta) {
        if (respuestaRepo.findById(idRespuesta) == null) {
            return false;
        }
        respuestaRepo.deleteById(idRespuesta);
        return true;
    }

}
