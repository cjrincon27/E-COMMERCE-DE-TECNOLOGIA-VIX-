package ChallengeFinal.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Console {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String brand;

    private String model;

    private double price;

    private int stock;

    private String ram;

    private String rom;

    private String controls;

    private String description;
    private String background;
    @ElementCollection
    @Column(name = "images")
    private Set<String> images = new HashSet<>();
    @OneToMany(mappedBy = "console",fetch = FetchType.EAGER)
    private List<Ticket_Console> ticketConsoles = new ArrayList<>();
    private boolean enable = true;


    public Console() {
    }

    public Console(String brand, String model, double price, int stock, String ram, String rom, String controls, String description, String background) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stock = stock;
        this.ram = ram;
        this.rom = rom;
        this.controls = controls;
        this.description = description;
        this.background = background;
    }

    public long getId() {
        return id;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getControls() {
        return controls;
    }

    public void setControls(String controls) {
        this.controls = controls;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }

    public List<Ticket_Console> getTicketConsoles() {
        return ticketConsoles;
    }

    public void setTicketConsoles(List<Ticket_Console> ticketConsoles) {
        this.ticketConsoles = ticketConsoles;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void addImage(String image) {
        this.images.add(image);
    }


}
