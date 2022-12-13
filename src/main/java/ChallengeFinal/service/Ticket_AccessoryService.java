package ChallengeFinal.service;

import ChallengeFinal.dtos.Ticket_AccesoryDTO;
import ChallengeFinal.models.Ticket_Accessory;

import java.util.List;

public interface Ticket_AccessoryService {
    public List<Ticket_AccesoryDTO> getTicket_AccessoryDTO();

    public Ticket_Accessory findById(long id);

    public void saveTicket_Accessory(Ticket_Accessory ticket_accessory);
}
