package ChallengeFinal.dtos;

import ChallengeFinal.models.Console;
import ChallengeFinal.models.TicketPurchase;
import ChallengeFinal.models.Ticket_Console;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

public class Ticket_ConsoleDTO {
    private long id;
//    private long ticketPurchaseId;
    private ConsoleDTO consoleDTO;
    private int stock;
    private Double price;

    public Ticket_ConsoleDTO(Ticket_Console ticket_console) {
        this.id = ticket_console.getId();
//        this.ticketPurchaseId = ticket_console.getTicketPurchase().getId();
        this.consoleDTO = new ConsoleDTO(ticket_console.getConsole());
        this.stock = ticket_console.getStock();
        this.price = ticket_console.getPrice();
    }

    public long getId() {
        return id;
    }

//    public long getTicketPurchaseId() {
//        return ticketPurchaseId;
//    }

    public ConsoleDTO getConsoleIdDTO() {
        return consoleDTO;
    }

    public int getStock() {
        return stock;
    }

    public Double getPrice() {
        return price;
    }
}
