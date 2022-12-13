package ChallengeFinal.service;

import ChallengeFinal.dtos.AccessoryImageAndColorDTO;
import ChallengeFinal.models.Accessory;
import ChallengeFinal.models.AccessoryImageAndColor;

import java.util.List;

public interface AccessoryImageAndColorService {
    public List<AccessoryImageAndColorDTO> getAccessoryImageAndColorDTOS();
    public void saveAccessoryImageAndColor(AccessoryImageAndColor accessoryImageAndColor);
    public AccessoryImageAndColor findByAccessory(Accessory accessory);

    public void deleteAccessoryImageAndColor(long id);
}
