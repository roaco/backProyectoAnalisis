package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.Entities.EncuestaItem;
import co.edu.uniquindio.PF_ANALISIS.Repositories.EncuestaItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EncuestaItemService {

    @Autowired
    private EncuestaItemRepo encuestaItemRepo;

    @Transactional
    public List<EncuestaItem> getAllEncuestaItems() {
        return encuestaItemRepo.findAll();
    }

    @Transactional
    public boolean crearEncuestaItem(EncuestaItem encuestaItem) {
        if (encuestaItemRepo.findById(encuestaItem.getIdEncuestaItem()) != null) {
            return false;
        }
        encuestaItemRepo.save(encuestaItem);
        return true;
    }

    @Transactional
    public boolean eliminarEncuestaItem(Integer idEncuestaItem) {
        if (encuestaItemRepo.findById(idEncuestaItem) == null) {
            return false;
        }
        encuestaItemRepo.deleteById(idEncuestaItem);
        return true;
    }
}
