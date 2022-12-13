package ChallengeFinal.dtos;

import ChallengeFinal.models.Console;
import net.bytebuddy.asm.Advice;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ConsoleDTO {
    private long id;

    private String brand;

    private String model;

    private double price;

    private int stock;

    private String ram;

    private String rom;

    private String controls;

    private String description;

    private Set<String> images;
    private Set<Long> ticketConsolesId = new HashSet<>();
    private String background;


    public ConsoleDTO() {
    }

    public ConsoleDTO(Console console) {
        this.id = console.getId();
        this.brand = console.getBrand();
        this.model = console.getModel();
        this.price = console.getPrice();
        this.stock = console.getStock();
        this.ram = console.getRam();
        this.rom = console.getRom();
        this.controls = console.getControls();
        this.description = console.getDescription();
        this.images = console.getImages();
        this.ticketConsolesId = console.getTicketConsoles().stream().map(ticket_console -> ticket_console.getId()).collect(Collectors.toSet());
        this.background = console.getBackground();
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

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getRam() {
        return ram;
    }

    public String getRom() {
        return rom;
    }

    public String getControls() {
        return controls;
    }

    public String getDescription() {
        return description;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }

    public Set<String> getImages() {
        return images;
    }

    public Set<Long> getTicketConsoles() {
        return ticketConsolesId;
    }

    public String getBackground() {
        return background;
    }
}
