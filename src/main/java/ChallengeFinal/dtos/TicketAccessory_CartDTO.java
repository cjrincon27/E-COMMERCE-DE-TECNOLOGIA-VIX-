package ChallengeFinal.dtos;

import ChallengeFinal.models.ShoppingCart;
import ChallengeFinal.models.TicketAccessory_Cart;
import ChallengeFinal.models.Ticket_Phone;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

public class TicketAccessory_CartDTO {
    private long id;
    private Ticket_AccesoryDTO ticket_accesoryDTO;
    private long shoppingCartId;

    public TicketAccessory_CartDTO() {
    }

    public TicketAccessory_CartDTO(TicketAccessory_Cart ticketAccessory_cart) {
        this.id = ticketAccessory_cart.getId();
        this.ticket_accesoryDTO = new Ticket_AccesoryDTO(ticketAccessory_cart.getTicket_accessory());
        this.shoppingCartId = ticketAccessory_cart.getShoppingCart().getId();
    }

    public long getId() {
        return id;
    }

    public Ticket_AccesoryDTO getTicket_accesoryDTO() {
        return ticket_accesoryDTO;
    }

    public long getShoppingCartId() {
        return shoppingCartId;
    }
}
