package ChallengeFinal.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
public class TicketPhone_Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_phone_id")
    private Ticket_Phone ticket_phone;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shoppingCart_id")
    private ShoppingCart shoppingCart;

    public TicketPhone_Cart() {
    }

    public TicketPhone_Cart(Ticket_Phone ticket_phone, ShoppingCart shoppingCart) {
        this.ticket_phone = ticket_phone;
        this.shoppingCart = shoppingCart;
        ticket_phone.addTicketPhone_Cart(this);
        shoppingCart.addTicketPhone_Cart(this);
    }

    public long getId() {
        return id;
    }

    public Ticket_Phone getTicket_phone() {
        return ticket_phone;
    }

    public void setTicket_phone(Ticket_Phone ticket_phone) {
        this.ticket_phone = ticket_phone;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
