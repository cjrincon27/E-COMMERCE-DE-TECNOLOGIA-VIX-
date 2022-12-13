package ChallengeFinal.controller;

import ChallengeFinal.dtos.AccessoryImageAndColorDTO;
import ChallengeFinal.service.AccessoryImageAndColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccessoryImageAndColorController {
    @Autowired
    AccessoryImageAndColorService accessoryImageAndColorService;

    @GetMapping("/api/accessory/image&color")
    public List<AccessoryImageAndColorDTO> getAccessoryImageAndColorDTOS() {
        return accessoryImageAndColorService.getAccessoryImageAndColorDTOS();
    }
}
