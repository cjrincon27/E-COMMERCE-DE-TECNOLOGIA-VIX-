package ChallengeFinal.service.implement;

import ChallengeFinal.dtos.PhoneDTO;
import ChallengeFinal.models.Phone;
import ChallengeFinal.repository.PhoneRepository;
import ChallengeFinal.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneImplement implements PhoneService {
    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public List<PhoneDTO> getPhoneDTO() {
        return phoneRepository.findAll().stream().filter(phone -> phone.isEnable()).map(phone -> new PhoneDTO(phone)).collect(Collectors.toList());
    }

    @Override
    public Page<PhoneDTO> getPhoneDTOPage(Pageable pageable) {
        List<PhoneDTO> allPhoneDTO = phoneRepository.findAll(pageable).stream().filter(phone -> phone.isEnable()).map(phone -> new PhoneDTO(phone)).collect(Collectors.toList());

        return new PageImpl<>(allPhoneDTO);
    }

    @Override
    public Phone findById(long id) {
        return phoneRepository.findById(id).orElse(null);
    }

    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public void savePhone(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void deleteById(long id) {
        phoneRepository.deleteById(id);
    }
}
