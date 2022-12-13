package ChallengeFinal.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
public class TicketConsole_Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_console_id")
    private Ticket_Console ticket_console;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shoppingCart_id")
    private ShoppingCart shoppingCart;

    public TicketConsole_Cart() {
    }

    public TicketConsole_Cart(Ticket_Console ticket_console, ShoppingCart shoppingCart) {
        this.ticket_console = ticket_console;
        this.shoppingCart = shoppingCart;
        shoppingCart.addTicketConsole_Cart(this);
        ticket_console.addTicketConsole_Cart(this);
    }

    public long getId() {
        return id;
    }

    public Ticket_Console getTicket_console() {
        return ticket_console;
    }

    public void setTicket_console(Ticket_Console ticket_console) {
        this.ticket_console = ticket_console;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
