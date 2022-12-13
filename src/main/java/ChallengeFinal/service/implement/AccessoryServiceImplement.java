package ChallengeFinal.service.implement;

import ChallengeFinal.dtos.AccessoryDTO;
import ChallengeFinal.models.Accessory;
import ChallengeFinal.repository.AccessoryRepository;
import ChallengeFinal.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessoryServiceImplement implements AccessoryService {
    @Autowired
    private AccessoryRepository accessoryRepository;

    @Override
    public List<AccessoryDTO> getAccessoryDTO() {
        return accessoryRepository.findAll().stream().filter(accessory -> accessory.isEnable()).map(accessory -> new AccessoryDTO(accessory)).collect(Collectors.toList());
    }

    @Override
    public Page<AccessoryDTO> getAccessoryDTOPage(Pageable pageable) {
        List<AccessoryDTO> allAccessoriesDTO = accessoryRepository.findAll().stream().filter(accessory -> accessory.isEnable()).map(accessory -> new AccessoryDTO(accessory)).collect(Collectors.toList());

        return new PageImpl<>(allAccessoriesDTO);
    }

    @Override
    public void saveAccessory(Accessory accessory) {
        accessoryRepository.save(accessory);
    }

    @Override
    public Accessory findById(long id) {
        return accessoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Accessory> findAll() {
        return accessoryRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        accessoryRepository.deleteById(id);
    }
}
