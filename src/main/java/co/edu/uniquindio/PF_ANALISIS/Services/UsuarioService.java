package co.edu.uniquindio.PF_ANALISIS.Services;


import co.edu.uniquindio.PF_ANALISIS.Entities.Usuario;
import co.edu.uniquindio.PF_ANALISIS.Repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;


    @Transactional
    public boolean createUsuario(Usuario usuario) {
        if (usuarioRepo.findById(usuario.getCedula()) != null) {
            usuarioRepo.save(usuario);
            return true;
        }
        return false;
    }

    @Transactional
    public List <Object[]> getAllUsuariosPuntaje() {
        return usuarioRepo.getUsuariosPuntaje();
    }

    @Transactional
    public List <Object[]> getResultadosTest(Integer id) {
        return usuarioRepo.getResultadosTest(id);
    }

}
