package ChallengeFinal.service;

import ChallengeFinal.dtos.PhoneImageAndColorDTO;
import ChallengeFinal.models.Phone;
import ChallengeFinal.models.PhoneImageAndColor;

import java.util.List;

public interface PhoneImageAndColorService {
    public List<PhoneImageAndColorDTO> getPhoneImageAndColorDTOS();
    public PhoneImageAndColor findByPhone(Phone phone);

    public void deleteById(long id);
}
