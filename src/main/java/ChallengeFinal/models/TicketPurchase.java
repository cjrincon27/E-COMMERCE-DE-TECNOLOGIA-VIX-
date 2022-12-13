package ChallengeFinal.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class TicketPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private double priceFinal = 0.0;
    private LocalDateTime purchaseDate;
    private LocalDateTime refundDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;
    @OneToMany(mappedBy = "ticketPurchase", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket_Accessory> ticketAccesories = new ArrayList<>();
    @OneToMany(mappedBy = "ticketPurchase", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket_Phone> ticketPhones = new ArrayList<>();
    @OneToMany(mappedBy = "ticketPurchase", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket_Console> ticketConsoles= new ArrayList<>();

    public TicketPurchase() {
    }

    public TicketPurchase( LocalDateTime purchaseDate, LocalDateTime refundDate) {
        this.purchaseDate = purchaseDate;
        this.refundDate = refundDate;
    }


    public long getId() {
        return id;
    }

    public double getPriceFinal() {
        return priceFinal;
    }

    public void setPriceFinal(double priceFinal) {
        this.priceFinal = priceFinal;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDateTime getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(LocalDateTime refundDate) {
        this.refundDate = refundDate;
    }

    public List<Ticket_Accessory> getTicketAccesories() {
        return ticketAccesories;
    }

    public void setTicketAccesories(List<Ticket_Accessory> ticketAccesories) {
        this.ticketAccesories = ticketAccesories;
    }

    public List<Ticket_Phone> getTicketPhones() {
        return ticketPhones;
    }

    public void setTicketPhones(List<Ticket_Phone> ticketPhones) {
        this.ticketPhones = ticketPhones;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public List<Ticket_Console> getTicketConsoles() {
        return ticketConsoles;
    }

    public void setTicketConsoles(List<Ticket_Console> ticketConsoles) {
        this.ticketConsoles = ticketConsoles;
    }

    public void addTicketPhone(Ticket_Phone ticket_phone){
        ticket_phone.setTicketPurchase(this);
        ticketPhones.add(ticket_phone);
        setPriceFinal(getPriceFinal() + ticket_phone.getPrice());
    }
    public void addTicketAccessory(Ticket_Accessory ticket_accessory){
        ticket_accessory.setTicketPurchase(this);
        ticketAccesories.add(ticket_accessory);
        setPriceFinal(getPriceFinal() + ticket_accessory.getPrice());
    }
    public void addTicketConsole(Ticket_Console ticket_console){
        ticket_console.setTicketPurchase(this);
        ticketConsoles.add(ticket_console);
        setPriceFinal(getPriceFinal() + ticket_console.getPrice());
    }
    public void addTicketPhoneAndTicketAccessory(Ticket_Phone ticket_phone,Ticket_Accessory ticket_accessory){
        addTicketPhone(ticket_phone);
        addTicketAccessory(ticket_accessory);
        setPriceFinal(getPriceFinal() + ticket_accessory.getPrice() + ticket_phone.getPrice());
    }
}
