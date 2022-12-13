package ChallengeFinal.dtos;

import ChallengeFinal.models.TicketPhone_Cart;
import ChallengeFinal.models.Ticket_Phone;

public class TicketPhone_CartDTO {
    private long id;
    private Ticket_PhoneDTO ticket_phoneDTO;
    private long shoppingCartId;

    public TicketPhone_CartDTO() {
    }

    public TicketPhone_CartDTO(TicketPhone_Cart ticketPhone_cart) {
        this.id = ticketPhone_cart.getId();
        this.ticket_phoneDTO = new Ticket_PhoneDTO(ticketPhone_cart.getTicket_phone());
        this.shoppingCartId = ticketPhone_cart.getShoppingCart().getId();
    }

    public long getId() {
        return id;
    }

    public Ticket_PhoneDTO getTicket_phoneDTO() {
        return ticket_phoneDTO;
    }

    public long getShoppingCartId() {
        return shoppingCartId;
    }
}
