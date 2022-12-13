package ChallengeFinal.service.implement;

import ChallengeFinal.dtos.AccessoryImageAndColorDTO;
import ChallengeFinal.models.Accessory;
import ChallengeFinal.models.AccessoryImageAndColor;
import ChallengeFinal.repository.AccessoryImageAndColorRepository;
import ChallengeFinal.service.AccessoryImageAndColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessoryImageAndColorServiceImplement implements AccessoryImageAndColorService {
    @Autowired
    private AccessoryImageAndColorRepository accessoryImageAndColorRepository;

    @Override
    public List<AccessoryImageAndColorDTO> getAccessoryImageAndColorDTOS() {
        return accessoryImageAndColorRepository.findAll().stream().map(accessoryImageAndColor -> new AccessoryImageAndColorDTO(accessoryImageAndColor)).collect(Collectors.toList());
    }

    @Override
    public void saveAccessoryImageAndColor(AccessoryImageAndColor accessoryImageAndColor) {
        accessoryImageAndColorRepository.save(accessoryImageAndColor);
    }

    @Override
    public AccessoryImageAndColor findByAccessory(Accessory accessory) {
        return accessoryImageAndColorRepository.findByAccessory(accessory);
    }

    @Override
    public void deleteAccessoryImageAndColor(long id) {
        accessoryImageAndColorRepository.deleteById(id);
    }
}
