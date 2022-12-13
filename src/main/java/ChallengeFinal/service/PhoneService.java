package ChallengeFinal.service;

import ChallengeFinal.dtos.PhoneDTO;
import ChallengeFinal.models.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PhoneService {
    public List<PhoneDTO> getPhoneDTO();

    public Page<PhoneDTO> getPhoneDTOPage(Pageable pageable);

    public Phone findById(long id);

    public List<Phone> findAll();

    public void savePhone(Phone phone);

    public void deleteById(long id);
}
