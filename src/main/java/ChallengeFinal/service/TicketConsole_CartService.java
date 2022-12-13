package ChallengeFinal.service;

import ChallengeFinal.dtos.TicketConsole_CartDTO;
import ChallengeFinal.models.TicketConsole_Cart;

import java.util.List;

public interface TicketConsole_CartService {
    public List<TicketConsole_CartDTO> ticketConsole_cartDTOS();
    public TicketConsole_Cart findById(long id);
    public void save(TicketConsole_Cart ticketConsole_cart);
    public void deleteById(Long id);
}
