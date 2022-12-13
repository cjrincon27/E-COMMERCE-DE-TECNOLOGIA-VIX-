package ChallengeFinal.dtos;

import ChallengeFinal.models.TicketConsole_Cart;
import ChallengeFinal.models.Ticket_Console;

public class TicketConsole_CartDTO {
    private long id;
    private Ticket_ConsoleDTO ticket_consoleDTO;
    private long shoppingCartId;

    public TicketConsole_CartDTO() {
    }

    public TicketConsole_CartDTO(TicketConsole_Cart ticketConsole_cart) {
        this.id = ticketConsole_cart.getId();
        this.ticket_consoleDTO = new Ticket_ConsoleDTO(ticketConsole_cart.getTicket_console());
        this.shoppingCartId = ticketConsole_cart.getShoppingCart().getId();
    }

    public long getId() {
        return id;
    }

    public Ticket_ConsoleDTO getTicket_consoleDTO() {
        return ticket_consoleDTO;
    }

    public long getShoppingCartId() {
        return shoppingCartId;
    }
}
