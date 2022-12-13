package ChallengeFinal.service;

import ChallengeFinal.dtos.TicketPurchaseDTO;
import ChallengeFinal.models.TicketPurchase;

import java.util.List;

public interface TicketPurchaseService {
    public TicketPurchase findById(long id);

    public List<TicketPurchaseDTO> getTicketPurchaseDTOS();

    public void saveTicketPurchase(TicketPurchase ticketPurchase);
}
