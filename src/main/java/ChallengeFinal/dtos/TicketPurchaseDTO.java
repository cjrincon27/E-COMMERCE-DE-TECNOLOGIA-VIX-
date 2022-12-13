package ChallengeFinal.dtos;

import ChallengeFinal.models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketPurchaseDTO {
    private long id;
    private double priceFinal;
    private LocalDateTime purchaseDate;
    private long buyerId;
    private LocalDateTime refundDate;
    private List<Ticket_AccesoryDTO> ticketAccesories = new ArrayList<>();
    private List<Ticket_PhoneDTO> ticketPhones = new ArrayList<>();
    private List<Ticket_ConsoleDTO> ticketConsoles = new ArrayList<>();

    public TicketPurchaseDTO() {
    }

    public TicketPurchaseDTO(TicketPurchase ticketPurchase) {
        this.id = ticketPurchase.getId();
        this.priceFinal = ticketPurchase.getPriceFinal();
        this.purchaseDate = ticketPurchase.getPurchaseDate();
        this.buyerId = ticketPurchase.getBuyer().getId();
        this.refundDate = ticketPurchase.getRefundDate();
        this.ticketAccesories = ticketPurchase.getTicketAccesories().stream().map(ticket_accesory -> new Ticket_AccesoryDTO(ticket_accesory)).collect(Collectors.toList());
        this.ticketPhones = ticketPurchase.getTicketPhones().stream().map(ticket_phone -> new Ticket_PhoneDTO(ticket_phone)).collect(Collectors.toList());
        this.ticketConsoles = ticketPurchase.getTicketConsoles().stream().map(ticket_console -> new Ticket_ConsoleDTO(ticket_console)).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public double getPriceFinal() {
        return priceFinal;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public LocalDateTime getRefundDate() {
        return refundDate;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public List<Ticket_AccesoryDTO> getTicketAccesories() {
        return ticketAccesories;
    }

    public List<Ticket_PhoneDTO> getTicketPhones() {
        return ticketPhones;
    }

    public List<Ticket_ConsoleDTO> getTicketConsoles() {
        return ticketConsoles;
    }
}
