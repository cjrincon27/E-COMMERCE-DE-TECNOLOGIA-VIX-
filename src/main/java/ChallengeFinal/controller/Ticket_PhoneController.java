package ChallengeFinal.controller;

import ChallengeFinal.dtos.Ticket_PhoneDTO;
import ChallengeFinal.service.Ticket_PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Ticket_PhoneController {
    @Autowired
    Ticket_PhoneService ticket_phoneService;

    @GetMapping("/api/ticket/phone")
    public List<Ticket_PhoneDTO> getTicket_phoneDTOS() {
        return ticket_phoneService.getTicket_phoneDTOS();
    }
}
