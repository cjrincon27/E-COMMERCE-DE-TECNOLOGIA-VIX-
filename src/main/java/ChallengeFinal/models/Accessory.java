package ChallengeFinal.models;

import ChallengeFinal.repository.AccessoryImageAndColorRepository;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    @Column(length = 500)
    private String description;
    private AccesoryType type;
    private String brand;
    private String model;
    private int stock;
    private Double price;
    private boolean enable = true;
    @OneToMany(mappedBy = "accessory",fetch = FetchType.LAZY)
    private List<AccessoryImageAndColor> accessoryImageAndColors = new ArrayList<>();
    @OneToMany(mappedBy = "accessory", fetch = FetchType.EAGER)
    private Set<Ticket_Accessory> ticketAccesories = new HashSet<>();
    public Accessory() {
    }

    public Accessory(String description, AccesoryType type, String brand, String model, int stock, Double price) {
        this.description = description;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.stock = stock;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccesoryType getType() {
        return type;
    }

    public void setType(AccesoryType type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public List<AccessoryImageAndColor> getAccessoryImageAndColors() {
        return accessoryImageAndColors;
    }

    public void setAccessoryImageAndColors(List<AccessoryImageAndColor> accessoryImageAndColors) {
        this.accessoryImageAndColors = accessoryImageAndColors;
    }

    public Set<Ticket_Accessory> getTicketAccesories() {
        return ticketAccesories;
    }

    public void setTicketAccesories(Set<Ticket_Accessory> ticketAccesories) {
        this.ticketAccesories = ticketAccesories;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public  void addImagesAndColor(AccessoryImageAndColor accessoryImageAndColor){
        accessoryImageAndColor.setAccessory(this);
        accessoryImageAndColors.add(accessoryImageAndColor);
    }


}
