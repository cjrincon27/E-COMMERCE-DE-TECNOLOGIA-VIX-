package ChallengeFinal.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
public class TicketAccessory_Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_accessory_id")
    private Ticket_Accessory ticket_accessory;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shoppingCart_id")
    private ShoppingCart shoppingCart;

    public TicketAccessory_Cart() {
    }

    public TicketAccessory_Cart(Ticket_Accessory ticket_accessory, ShoppingCart shoppingCart) {
        this.ticket_accessory = ticket_accessory;
        this.shoppingCart = shoppingCart;
        ticket_accessory.addTicketAccessory_cart(this);
        shoppingCart.addTicketAccessory_Cart(this);
    }

    public long getId() {
        return id;
    }

    public Ticket_Accessory getTicket_accessory() {
        return ticket_accessory;
    }

    public void setTicket_accessory(Ticket_Accessory ticket_accessory) {
        this.ticket_accessory = ticket_accessory;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
