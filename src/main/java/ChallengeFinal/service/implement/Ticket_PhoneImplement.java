package ChallengeFinal.service.implement;

import ChallengeFinal.dtos.Ticket_PhoneDTO;
import ChallengeFinal.models.Ticket_Phone;
import ChallengeFinal.repository.Ticket_PhoneRepository;
import ChallengeFinal.service.Ticket_PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Ticket_PhoneImplement implements Ticket_PhoneService {
    @Autowired
    Ticket_PhoneRepository ticket_phoneRepository;

    @Override
    public List<Ticket_PhoneDTO> getTicket_phoneDTOS() {
        return ticket_phoneRepository.findAll().stream().map(ticket_phone -> new Ticket_PhoneDTO(ticket_phone)).collect(Collectors.toList());
    }

    @Override
    public Ticket_Phone findById(long id) {
        return ticket_phoneRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTicket_Phone(Ticket_Phone ticket_phone) {
        ticket_phoneRepository.save(ticket_phone);
    }
}
