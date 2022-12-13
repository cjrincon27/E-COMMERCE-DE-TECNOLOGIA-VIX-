package ChallengeFinal.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ticket_Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticketPurchase_id")
    private TicketPurchase ticketPurchase;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accesory_id")
    private Accessory accessory;
    @OneToMany(mappedBy = "ticket_accessory",fetch = FetchType.LAZY)
    private List<TicketAccessory_Cart> ticketAccessory_carts = new ArrayList<>();
    private int stock;
    private Double price;
    private String color;

    public Ticket_Accessory() {
    }

    public Ticket_Accessory(Accessory accessory, int stock,String color) {
        this.accessory = accessory;
        this.stock = stock;
        this.price = accessory.getPrice() * stock;
        this.color= color;
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

    public Accessory getAccessory() {
        return accessory;
    }

    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
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

    public List<TicketAccessory_Cart> getTicketAccessory_carts() {
        return ticketAccessory_carts;
    }

    public void setTicketAccessory_carts(List<TicketAccessory_Cart> ticketAccessory_carts) {
        this.ticketAccessory_carts = ticketAccessory_carts;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void addTicketAccessory_cart(TicketAccessory_Cart ticketAccessory_cart) {
        ticketAccessory_carts.add(ticketAccessory_cart);
    }
}
