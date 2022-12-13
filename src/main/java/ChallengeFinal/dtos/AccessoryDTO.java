package ChallengeFinal.dtos;

import ChallengeFinal.models.AccesoryType;
import ChallengeFinal.models.Accessory;
import ChallengeFinal.models.AccessoryImageAndColor;
import ChallengeFinal.models.Ticket_Accessory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AccessoryDTO {
    private long id;
    private String description;
    private AccesoryType type;
    private String brand;
    private String model;
    private int stock;
    private Double price;
    private List<AccessoryImageAndColorDTO> accessoryImageAndColorDTOS = new ArrayList<>();
    private Set<Long> ticketAccesoriesId = new HashSet<>();

    public AccessoryDTO() {
    }

    public AccessoryDTO(Accessory accessory) {
        this.id = accessory.getId();
        this.description = accessory.getDescription();
        this.type = accessory.getType();
        this.brand = accessory.getBrand();
        this.model = accessory.getModel();
        this.stock = accessory.getStock();
        this.price = accessory.getPrice();
        this.accessoryImageAndColorDTOS = accessory.getAccessoryImageAndColors().stream().map(accessoryImageAndColor -> new AccessoryImageAndColorDTO(accessoryImageAndColor)).collect(Collectors.toList());
        this.ticketAccesoriesId = accessory.getTicketAccesories().stream().map(ticket_accessory -> ticket_accessory.getId()).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public AccesoryType getType() {
        return type;
    }

    public int getStock() {
        return stock;
    }

    public Double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public List<AccessoryImageAndColorDTO> getAccessoryImageAndColorDTOS() {
        return accessoryImageAndColorDTOS;
    }

    public Set<Long> getTicketAccesoriesId() {
        return ticketAccesoriesId;
    }
}
