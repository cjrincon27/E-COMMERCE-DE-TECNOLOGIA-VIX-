package ChallengeFinal.dtos;

import ChallengeFinal.models.AccessoryImageAndColor;

import java.util.List;

public class AccessoryImageAndColorDTO {
    private long id;
    private List<String> linksImages;
    private String color;
    private long accessoryId;

    public AccessoryImageAndColorDTO(AccessoryImageAndColor accessoryImageAndColor) {
        this.id = accessoryImageAndColor.getId();
        this.linksImages = accessoryImageAndColor.getLinkImage();
        this.color = accessoryImageAndColor.getAccessoryColor();
        this.accessoryId = accessoryImageAndColor.getAccessory().getId();
    }

    public long getId() {
        return id;
    }

    public List<String> getLinksImages() {
        return linksImages;
    }

    public String getColor() {
        return color;
    }

    public long getAccessoryId() {
        return accessoryId;
    }
}
