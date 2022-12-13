package ChallengeFinal.dtos;

import java.util.ArrayList;
import java.util.List;

public class NewPhoneDTO {
    private String brand;
    private String model;
    private final List<String> ram = new ArrayList<>();
    private final List<String> rom = new ArrayList<>();
    private String cameraDescription;
    private String processor;
    private Double price;
    private int stock;
    private String battery;
    private String size;
    private final List<String> linkImage = new ArrayList<>();
    private String phoneColor;

    public NewPhoneDTO() {
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public List<String> getRAM() {
        return ram;
    }

    public List<String> getROM() {
        return rom;
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

    public String getBattery() {
        return battery;
    }

    public String getSize() {
        return size;
    }

    public List<String> getLinkImage() {
        return linkImage;
    }

    public String getPhoneColor() {
        return phoneColor;
    }
}
