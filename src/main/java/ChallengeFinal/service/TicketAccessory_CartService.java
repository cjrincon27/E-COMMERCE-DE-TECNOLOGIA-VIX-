package ChallengeFinal.service;

import ChallengeFinal.dtos.TicketAccessory_CartDTO;
import ChallengeFinal.models.TicketAccessory_Cart;

import java.util.List;

public interface TicketAccessory_CartService {
    public List<TicketAccessory_CartDTO> getTicketAccessory_cartDTOS();
    public TicketAccessory_Cart findById(Long id);
    public void save(TicketAccessory_Cart ticketAccessory_cart);
    public void deleteById(Long id);
}
