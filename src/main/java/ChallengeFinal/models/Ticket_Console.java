package ChallengeFinal.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ticket_Console {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticketPurchase_id")
    private TicketPurchase ticketPurchase;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "console_id")
    private Console console;
    @OneToMany(mappedBy = "ticket_console",fetch = FetchType.LAZY)
    private List<TicketConsole_Cart> ticketConsole_carts = new ArrayList<>();
    private int stock;
    private Double price;

    public Ticket_Console() {
    }

    public Ticket_Console( Console console, int stock) {
        this.ticketPurchase = ticketPurchase;
        this.console = console;
        this.stock = stock;
        this.price = console.getPrice() * stock;
    }

    public long getId() {
        return id;
    }

    public TicketPurchase getTicketPurchase() {
        return ticketPurchase;
    }

    public void setTicketPurchase(TicketPurchase ticketPurchase) {
        this.ticketPurchase = ticketPurchase;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<TicketConsole_Cart> getTicketConsole_carts() {
        return ticketConsole_carts;
    }

    public void setTicketConsole_carts(List<TicketConsole_Cart> ticketConsole_carts) {
        this.ticketConsole_carts = ticketConsole_carts;
    }
    public void addTicketConsole_Cart(TicketConsole_Cart ticketConsole_cart){
        ticketConsole_carts.add(ticketConsole_cart);
    }
}
