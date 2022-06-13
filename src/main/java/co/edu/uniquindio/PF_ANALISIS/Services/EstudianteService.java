package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.Entities.Usuario;
import co.edu.uniquindio.PF_ANALISIS.Repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EstudianteService {
    @Autowired
    private UsuarioRepo usuarioRepo;


    @Transactional
    public boolean createEstudiante(Usuario usuario) {
        if (usuarioRepo.findById(usuario.getCedula()) != null) {
            usuarioRepo.save(usuario);
            return true;
        }
        return false;
    }

    @Transactional
    public List <Object[]> getAllEstudiantesPuntaje() {
        return usuarioRepo.getEstudiantesPuntaje();
    }

    @Transactional
    public List <Object[]> getResultadosTest(Integer id) {
        return usuarioRepo.getResultadosTest(id);
    }

}
