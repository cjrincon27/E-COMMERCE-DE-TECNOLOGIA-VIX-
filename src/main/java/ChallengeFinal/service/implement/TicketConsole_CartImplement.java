package ChallengeFinal.service.implement;

import ChallengeFinal.dtos.TicketConsole_CartDTO;
import ChallengeFinal.models.TicketConsole_Cart;
import ChallengeFinal.repository.TicketConsole_CartRepository;
import ChallengeFinal.service.TicketConsole_CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketConsole_CartImplement implements TicketConsole_CartService {
    @Autowired
    TicketConsole_CartRepository ticketConsole_cartRepository;

    @Override
    public List<TicketConsole_CartDTO> ticketConsole_cartDTOS() {
        return ticketConsole_cartRepository.findAll().stream().map(ticketConsole_cart -> new TicketConsole_CartDTO(ticketConsole_cart)).collect(Collectors.toList());
    }

    @Override
    public TicketConsole_Cart findById(long id) {
        return ticketConsole_cartRepository.findById(id).orElse(null);
    }

    @Override
    public void save(TicketConsole_Cart ticketConsole_cart) {
        ticketConsole_cartRepository.save(ticketConsole_cart);
    }

    @Override
    public void deleteById(Long id) {
        ticketConsole_cartRepository.deleteById(id);
    }
}
