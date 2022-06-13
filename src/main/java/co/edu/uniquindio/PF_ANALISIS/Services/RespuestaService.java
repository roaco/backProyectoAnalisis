package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.Entities.Respuesta;
import co.edu.uniquindio.PF_ANALISIS.Repositories.RespuestaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RespuestaService {
    @Autowired
    private RespuestaRepo respuestaRepo;
    @Transactional
    public boolean createRespuesta(Respuesta respuesta) {
        if (respuestaRepo.findById(respuesta.getIdRespuesta()) != null) {
            respuestaRepo.save(respuesta);
            return true;
        }
        return false;
    }

    @Transactional
    public List<Object[]> getPreguntasTYF(){
        return respuestaRepo.getPreguntasTYF();
    }

    @Transactional
    public List<Object[]> getPromedioPreguntas(){
        return respuestaRepo.getPromedioPreguntas();
    }
}
