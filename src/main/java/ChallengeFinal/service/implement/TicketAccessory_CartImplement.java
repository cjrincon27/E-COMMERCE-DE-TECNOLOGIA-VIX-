package ChallengeFinal.service.implement;

import ChallengeFinal.dtos.TicketAccessory_CartDTO;
import ChallengeFinal.models.TicketAccessory_Cart;
import ChallengeFinal.repository.TicketAccessory_CartRepository;
import ChallengeFinal.service.TicketAccessory_CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketAccessory_CartImplement implements TicketAccessory_CartService {
    @Autowired
    TicketAccessory_CartRepository ticketAccessory_cartRepository;

    @Override
    public List<TicketAccessory_CartDTO> getTicketAccessory_cartDTOS() {
        return ticketAccessory_cartRepository.findAll().stream().map(ticketAccessoryCart -> new TicketAccessory_CartDTO(ticketAccessoryCart)).collect(Collectors.toList());
    }

    @Override
    public TicketAccessory_Cart findById(Long id) {
        return ticketAccessory_cartRepository.findById(id).orElse(null);
    }

    @Override
    public void save(TicketAccessory_Cart ticketAccessory_cart) {
        ticketAccessory_cartRepository.save(ticketAccessory_cart);
    }

    @Override
    public void deleteById(Long id) {
        ticketAccessory_cartRepository.deleteById(id);
    }
}
