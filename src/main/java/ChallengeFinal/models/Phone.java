package ChallengeFinal.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String brand;
    private String model;
    @ElementCollection
    @Column(name = "ram")
    private List<Integer> RAM;
    @ElementCollection
    @Column(name = "rom")
    private List<Integer> ROM;
    @OneToMany(mappedBy = "phone",fetch = FetchType.EAGER)
    private Set<PhoneImageAndColor> phoneImageAndColors = new HashSet<>();
    private String cameraDescription;
    private String processor;
    private Double price;
    private int stock;
    @OneToMany(mappedBy = "phone", fetch = FetchType.EAGER)
    private Set<Ticket_Phone> ticketPhones = new HashSet<>();
    private String battery;
    private String size;
    private boolean enable = true;


    public Phone() {
    }

    public Phone(String brand, String model, List<Integer> RAM, List<Integer> ROM, String cameraDescription, String processor, Double price, int stock, String battery, String size) {
        this.brand = brand;
        this.model = model;
        this.RAM = RAM;
        this.ROM = ROM;
        this.cameraDescription = cameraDescription;
        this.processor = processor;
        this.price = price;
        this.stock = stock;
        this.battery = battery;
        this.size = size;
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

    public List<Integer> getRAM() {
        return RAM;
    }

    public void setRAM(List<Integer> RAM) {
        this.RAM = RAM;
    }

    public List<Integer> getROM() {
        return ROM;
    }

    public void setROM(List<Integer> ROM) {
        this.ROM = ROM;
    }

    public Set<PhoneImageAndColor> getPhoneImages() {
        return phoneImageAndColors;
    }

    public void setPhoneImages(Set<PhoneImageAndColor> phoneImageAndColors) {
        this.phoneImageAndColors = phoneImageAndColors;
    }


    public String getCameraDescription() {
        return cameraDescription;
    }

    public void setCameraDescription(String cameraDescription) {
        this.cameraDescription = cameraDescription;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Set<Ticket_Phone> getTicketPhones() {
        return ticketPhones;
    }

    public void setTicketPhones(Set<Ticket_Phone> ticketPhones) {
        this.ticketPhones = ticketPhones;
    }

    public Set<PhoneImageAndColor> getPhoneImageAndColors() {
        return phoneImageAndColors;
    }

    public void setPhoneImageAndColors(Set<PhoneImageAndColor> phoneImageAndColors) {
        this.phoneImageAndColors = phoneImageAndColors;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void addImagesAndColor(PhoneImageAndColor phoneImageAndColor){
        phoneImageAndColor.setPhone(this);
        phoneImageAndColors.add(phoneImageAndColor);
    }
}
