package ChallengeFinal.service.implement;

import ChallengeFinal.dtos.Ticket_ConsoleDTO;
import ChallengeFinal.models.Ticket_Console;
import ChallengeFinal.repository.Ticket_ConsoleRepository;
import ChallengeFinal.service.Ticket_ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Ticket_ConsoleImplement implements Ticket_ConsoleService {
    @Autowired
    Ticket_ConsoleRepository ticket_consoleRepository;

    @Override
    public List<Ticket_ConsoleDTO> getTicketConsolesDTO() {
        return ticket_consoleRepository.findAll().stream().map(ticket_console -> new Ticket_ConsoleDTO(ticket_console)).collect(Collectors.toList());
    }

    @Override
    public Ticket_Console findById(long id) {
        return ticket_consoleRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTicket_Console(Ticket_Console ticket_console) {
        ticket_consoleRepository.save(ticket_console);
    }
}
