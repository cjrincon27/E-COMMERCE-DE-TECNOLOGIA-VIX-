package ChallengeFinal.service;

import ChallengeFinal.dtos.Ticket_ConsoleDTO;
import ChallengeFinal.models.Ticket_Console;

import java.util.List;

public interface Ticket_ConsoleService {
    public List<Ticket_ConsoleDTO> getTicketConsolesDTO();

    public Ticket_Console findById(long id);

    public void saveTicket_Console(Ticket_Console ticket_console);
}
