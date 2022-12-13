package ChallengeFinal.controller;

import ChallengeFinal.dtos.Ticket_ConsoleDTO;
import ChallengeFinal.service.Ticket_ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Ticket_ConsoleController {
    @Autowired
    Ticket_ConsoleService ticket_ConsoleService;

    @GetMapping("/api/ticket/console")
    public List<Ticket_ConsoleDTO> ticketConsoles() {
        return ticket_ConsoleService.getTicketConsolesDTO();
    }
}
