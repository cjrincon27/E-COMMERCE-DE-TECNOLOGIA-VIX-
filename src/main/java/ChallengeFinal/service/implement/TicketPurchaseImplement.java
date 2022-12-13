package ChallengeFinal.service.implement;

import ChallengeFinal.dtos.TicketPurchaseDTO;
import ChallengeFinal.models.TicketPurchase;
import ChallengeFinal.repository.TicketPurchaseRepository;
import ChallengeFinal.service.TicketPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketPurchaseImplement implements TicketPurchaseService {
    @Autowired
    TicketPurchaseRepository ticketPurchaseRepository;

    @Override
    public TicketPurchase findById(long id) {
        return ticketPurchaseRepository.findById(id).orElse(null);
    }

    @Override
    public List<TicketPurchaseDTO> getTicketPurchaseDTOS() {
        return ticketPurchaseRepository.findAll().stream().map(ticketPurchase -> new TicketPurchaseDTO(ticketPurchase))
                .collect(Collectors.toList());
    }

    @Override
    public void saveTicketPurchase(TicketPurchase ticketPurchase) {
        ticketPurchaseRepository.save(ticketPurchase);
    }
}
