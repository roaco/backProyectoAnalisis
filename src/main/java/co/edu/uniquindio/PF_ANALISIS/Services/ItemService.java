package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.DTO.ItemDTO;
import co.edu.uniquindio.PF_ANALISIS.Entities.Item;
import co.edu.uniquindio.PF_ANALISIS.Repositories.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Transactional
    public List<ItemDTO> getAllItems() {
        return itemRepo.getPromedioOpinion();
    }

    @Transactional
    public boolean crearItem(Item item) {
        if (itemRepo.findById(item.getIdItem()) != null) {
            return false;
        }
        itemRepo.save(item);
        return true;
    }

    @Transactional
    public boolean eliminarItem(Integer idItem) {
        if (itemRepo.findById(idItem) == null) {
            return false;
        }
        itemRepo.deleteById(idItem);
        return true;
    }

}
