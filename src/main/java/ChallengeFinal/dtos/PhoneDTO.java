package ChallengeFinal.dtos;

import ChallengeFinal.models.Phone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PhoneDTO {
    private long id;
    private String brand;
    private String model;
    private List<Integer> RAM;
    private List<Integer> ROM;
    private List<PhoneImageAndColorDTO> phoneImageAndColorDTOS = new ArrayList<>();
    private String cameraDescription;
    private String processor;
    private Double price;
    private int stock;
    private Set<Long> ticketPhonesId = new HashSet<>();

    public PhoneDTO() {
    }

    public PhoneDTO(Phone phone) {
        this.id = phone.getId();
        this.brand = phone.getBrand();
        this.model = phone.getModel();
        this.RAM = phone.getRAM();
        this.ROM = phone.getROM();
        this.phoneImageAndColorDTOS = phone.getPhoneImageAndColors().stream().map(phoneImageAndColor -> new PhoneImageAndColorDTO(phoneImageAndColor)).collect(Collectors.toList());
        this.cameraDescription = phone.getCameraDescription();
        this.processor = phone.getProcessor();
        this.price = phone.getPrice();
        this.stock = phone.getStock();
        this.ticketPhonesId = phone.getTicketPhones().stream().map(ticket_phone -> ticket_phone.getId()).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public List<Integer> getRAM() {
        return RAM;
    }

    public List<Integer> getROM() {
        return ROM;
    }

    public List<PhoneImageAndColorDTO> getPhoneImageAndColorDTOS() {
        return phoneImageAndColorDTOS;
    }

    public String getCameraDescription() {
        return cameraDescription;
    }

    public String getProcessor() {
        return processor;
    }

    public Double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public Set<Long> getTicketPhonesId() {
        return ticketPhonesId;
    }
}
