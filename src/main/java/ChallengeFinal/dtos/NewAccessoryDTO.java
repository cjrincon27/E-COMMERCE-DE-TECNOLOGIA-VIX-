package ChallengeFinal.dtos;

import ChallengeFinal.models.AccesoryType;

import java.util.ArrayList;
import java.util.List;

public class NewAccessoryDTO {
    private String description;
    private String type;
    private String brand;
    private String model;
    private int stock;
    private Double price;
    private List<String> linkImage = new ArrayList<>();
    private String accessoryColor;

    public NewAccessoryDTO() {
    }

    public NewAccessoryDTO(String description, String type, String brand, String model, int stock, Double price, List<String> linkImage, String accessoryColor) {
        this.description = description;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.stock = stock;
        this.price = price;
        this.linkImage = linkImage;
        this.accessoryColor = accessoryColor;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getStock() {
        return stock;
    }

    public Double getPrice() {
        return price;
    }



    public List<String> getLinkImage() {
        return linkImage;
    }

    public String getAccessoryColor() {
        return accessoryColor;
    }
}
