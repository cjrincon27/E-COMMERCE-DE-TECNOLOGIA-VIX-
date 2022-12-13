package ChallengeFinal.service.implement;

import ChallengeFinal.dtos.PhoneImageAndColorDTO;
import ChallengeFinal.models.Phone;
import ChallengeFinal.models.PhoneImageAndColor;
import ChallengeFinal.repository.PhoneImageAndColorRepository;
import ChallengeFinal.service.PhoneImageAndColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneImageAndColorImplement implements PhoneImageAndColorService {
    @Autowired
    PhoneImageAndColorRepository phoneImageAndColorRepository;

    @Override
    public List<PhoneImageAndColorDTO> getPhoneImageAndColorDTOS() {
        return phoneImageAndColorRepository.findAll().stream().map(phoneImageAndColor -> new PhoneImageAndColorDTO(phoneImageAndColor)).collect(Collectors.toList());
    }

    @Override
    public PhoneImageAndColor findByPhone(Phone phone) {
        return phoneImageAndColorRepository.findByPhone(phone);
    }

    @Override
    public void deleteById(long id){
        phoneImageAndColorRepository.deleteById(id);
    }
}
