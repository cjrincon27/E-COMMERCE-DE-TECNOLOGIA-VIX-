package ChallengeFinal.service;

import ChallengeFinal.dtos.Ticket_PhoneDTO;
import ChallengeFinal.models.Ticket_Phone;

import java.util.List;

public interface Ticket_PhoneService {
    public List<Ticket_PhoneDTO> getTicket_phoneDTOS();

    public Ticket_Phone findById(long id);

    public void saveTicket_Phone(Ticket_Phone ticket_phone);
}
