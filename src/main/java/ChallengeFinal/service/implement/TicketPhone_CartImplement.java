package ChallengeFinal.service.implement;

import ChallengeFinal.dtos.TicketPhone_CartDTO;
import ChallengeFinal.models.TicketPhone_Cart;
import ChallengeFinal.repository.TicketPhone_CarRepository;
import ChallengeFinal.service.TicketPhone_CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketPhone_CartImplement implements TicketPhone_CartService {
    @Autowired
    TicketPhone_CarRepository ticketPhone_CarRepository;

    @Override
    public List<TicketPhone_CartDTO> getTicketPhone_CartDTO() {
        return ticketPhone_CarRepository.findAll().stream().map(ticketPhone_cart -> new TicketPhone_CartDTO(ticketPhone_cart)).collect(Collectors.toList());
    }

    @Override
    public TicketPhone_Cart findById(Long id) {
        return ticketPhone_CarRepository.findById(id).orElse(null);
    }

    @Override
    public void save(TicketPhone_Cart ticketPhone_cart) {
        ticketPhone_CarRepository.save(ticketPhone_cart);
    }

    @Override
    public void deleteById(long id) {
        ticketPhone_CarRepository.deleteById(id);
    }
}
