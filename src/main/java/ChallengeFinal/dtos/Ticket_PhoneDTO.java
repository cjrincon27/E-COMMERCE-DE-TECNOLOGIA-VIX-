package ChallengeFinal.dtos;

import ChallengeFinal.models.Phone;
import ChallengeFinal.models.TicketPurchase;
import ChallengeFinal.models.Ticket_Phone;
import org.springframework.lang.Nullable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Ticket_PhoneDTO {
    private long id;
//    private long ticketPurchaseId ;
    private PhoneDTO phoneDTO;
    private int stock;
    private Double price;
    private String color;

    public Ticket_PhoneDTO() {
    }

    public Ticket_PhoneDTO(Ticket_Phone ticket_phone) {
        this.id = ticket_phone.getId();
//        this.ticketPurchaseId = ticket_phone.getTicketPurchase().getId();
        this.phoneDTO = new PhoneDTO(ticket_phone.getPhone());
        this.stock = ticket_phone.getStock();
        this.price = ticket_phone.getPrice();
        this.color = ticket_phone.getColor();
    }

    public long getId() {
        return id;
    }

//    public long getTicketPurchaseId() {
//        return ticketPurchaseId;
//    }

    public PhoneDTO getPhoneDTO() {
        return phoneDTO;
    }

    public int getStock() {
        return stock;
    }

    public Double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}
