package ChallengeFinal.controller;

import ChallengeFinal.dtos.Ticket_AccesoryDTO;
import ChallengeFinal.service.Ticket_AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class Ticket_AccessoryController {
    @Autowired
    Ticket_AccessoryService ticketAccessoryService;
    @GetMapping("/api/ticket/accessory")
    public List<Ticket_AccesoryDTO> getTicket_AccessoryDTO(){
        return ticketAccessoryService.getTicket_AccessoryDTO();
    }
}
