package ChallengeFinal.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Ticket_Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticketPurchase_id")
    private TicketPurchase ticketPurchase;
    @JoinColumn(name = "phone_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Phone phone;
    private int stock;
    private Double price;
    @OneToMany(mappedBy = "ticket_phone", fetch = FetchType.LAZY)
    private List<TicketPhone_Cart> ticketPhone_carts = new ArrayList<>();
    private String color;

    public Ticket_Phone() {
    }

    public Ticket_Phone( Phone phone, int stock,String color) {
        this.phone = phone;
        this.stock = stock;
        this.price = phone.getPrice() * stock;
        this.color = color;
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

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
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

    public List<TicketPhone_Cart> getTicketPhone_carts() {
        return ticketPhone_carts;
    }

    public void setTicketPhone_carts(List<TicketPhone_Cart> ticketPhone_carts) {
        this.ticketPhone_carts = ticketPhone_carts;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void addTicketPhone_Cart(TicketPhone_Cart ticketPhone_cart){
        ticketPhone_carts.add(ticketPhone_cart);
    }
}
