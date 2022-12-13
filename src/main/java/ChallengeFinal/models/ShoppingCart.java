package ChallengeFinal.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;
    @OneToMany(mappedBy = "shoppingCart")
    private List<TicketAccessory_Cart> ticketAccessory_carts = new ArrayList<>();
    @OneToMany(mappedBy = "shoppingCart")
    private List<TicketConsole_Cart> ticketConsole_carts = new ArrayList<>();
    @OneToMany(mappedBy = "shoppingCart")
    private List<TicketPhone_Cart> ticketPhone_carts = new ArrayList<>();


    public ShoppingCart() {
    }

    public ShoppingCart(Buyer buyer) {
        this.buyer = buyer;
    }

    public long getId() {
        return id;
    }


    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public List<TicketAccessory_Cart> getTicketAccessory_carts() {
        return ticketAccessory_carts;
    }

    public void setTicketAccessory_carts(List<TicketAccessory_Cart> ticketAccessory_carts) {
        this.ticketAccessory_carts = ticketAccessory_carts;
    }

    public List<TicketConsole_Cart> getTicketConsole_carts() {
        return ticketConsole_carts;
    }

    public void setTicketConsole_carts(List<TicketConsole_Cart> ticketConsole_carts) {
        this.ticketConsole_carts = ticketConsole_carts;
    }

    public List<TicketPhone_Cart> getTicketPhone_carts() {
        return ticketPhone_carts;
    }

    public void setTicketPhone_carts(List<TicketPhone_Cart> ticketPhone_carts) {
        this.ticketPhone_carts = ticketPhone_carts;
    }

    public void addTicketAccessory_Cart(TicketAccessory_Cart ticketAccessory_cart) {
        ticketAccessory_cart.setShoppingCart(this);
    }
    public void addTicketConsole_Cart(TicketConsole_Cart ticketConsole_cart){
        ticketConsole_carts.add(ticketConsole_cart);
    }
    public void addTicketPhone_Cart(TicketPhone_Cart ticketPhone_cart){
        ticketPhone_carts.add(ticketPhone_cart);
    }
}
