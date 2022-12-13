package ChallengeFinal.controller;

import ChallengeFinal.dtos.PhoneImageAndColorDTO;
import ChallengeFinal.service.PhoneImageAndColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneImageAndColorController {
    @Autowired
    PhoneImageAndColorService phoneImageAndColorService;

    @GetMapping("/api/phone/image&color")
    public List<PhoneImageAndColorDTO> getPhoneImageAndColorDTOS() {
        return phoneImageAndColorService.getPhoneImageAndColorDTOS();
    }
}
