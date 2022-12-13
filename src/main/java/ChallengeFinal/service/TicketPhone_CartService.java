package ChallengeFinal.service;

import ChallengeFinal.dtos.TicketPhone_CartDTO;
import ChallengeFinal.models.TicketPhone_Cart;

import java.util.List;

public interface TicketPhone_CartService {
    public List<TicketPhone_CartDTO> getTicketPhone_CartDTO();
    public TicketPhone_Cart findById(Long id);
    public void save(TicketPhone_Cart ticketPhone_cart);
    public void deleteById(long id);
}
