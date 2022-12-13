package ChallengeFinal.dtos;

import ChallengeFinal.models.Accessory;
import ChallengeFinal.models.TicketPurchase;
import ChallengeFinal.models.Ticket_Accessory;

public class Ticket_AccesoryDTO {
    private long id;
//    private long ticketPurchaseId;
    private AccessoryDTO accessoryDTO;
    private int stock;
    private Double price;
    private String color;
    public Ticket_AccesoryDTO() {
    }

    public Ticket_AccesoryDTO(Ticket_Accessory ticket_accessory) {
        this.id = ticket_accessory.getId();
//        this.ticketPurchaseId = ticket_accessory.getTicketPurchase().getId();
        this.accessoryDTO = new AccessoryDTO(ticket_accessory.getAccessory());
        this.stock = ticket_accessory.getStock();
        this.price = ticket_accessory.getPrice();
        this.color = ticket_accessory.getColor();
    }

    public long getId() {
        return id;
    }

//    public long getTicketPurchaseId() {
//        return ticketPurchaseId;
//    }

    public AccessoryDTO getAccessoryDTO() {
        return accessoryDTO;
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
