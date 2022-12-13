package ChallengeFinal.dtos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewConsoleDTO {
    private String brand;
    private String model;
    private double price;
    private int stock;
    private String ram;
    private String rom;
    private String controls;
    private String description;
    private List<String> images = new ArrayList<>();
    private String imageBg;


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

    public List<String> getImages() {
        return images;
    }

    public String getImageBg() {
        return imageBg;
    }
}
