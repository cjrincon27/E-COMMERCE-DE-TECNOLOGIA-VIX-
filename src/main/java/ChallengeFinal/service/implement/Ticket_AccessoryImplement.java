package ChallengeFinal.service.implement;

import ChallengeFinal.dtos.Ticket_AccesoryDTO;
import ChallengeFinal.models.Ticket_Accessory;
import ChallengeFinal.repository.Ticket_AccesoryRepository;
import ChallengeFinal.service.Ticket_AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Ticket_AccessoryImplement implements Ticket_AccessoryService {
    @Autowired
    Ticket_AccesoryRepository ticket_accesoryRepository;

    @Override
    public List<Ticket_AccesoryDTO> getTicket_AccessoryDTO() {
        return ticket_accesoryRepository.findAll().stream().map(ticket_accessory -> new Ticket_AccesoryDTO(ticket_accessory)).collect(Collectors.toList());
    }

    @Override
    public Ticket_Accessory findById(long id) {
        return ticket_accesoryRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTicket_Accessory(Ticket_Accessory ticket_accessory) {
        ticket_accesoryRepository.save(ticket_accessory);
    }
}
