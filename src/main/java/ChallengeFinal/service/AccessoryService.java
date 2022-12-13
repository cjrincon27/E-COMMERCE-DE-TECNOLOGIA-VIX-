package ChallengeFinal.service;

import ChallengeFinal.dtos.AccessoryDTO;
import ChallengeFinal.models.Accessory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccessoryService {
    public List<AccessoryDTO> getAccessoryDTO();

    public Page<AccessoryDTO> getAccessoryDTOPage(Pageable pageable);

    public void saveAccessory(Accessory accessory);

    public Accessory findById(long id);

    public List<Accessory> findAll();

    public void deleteById(long id);
}
