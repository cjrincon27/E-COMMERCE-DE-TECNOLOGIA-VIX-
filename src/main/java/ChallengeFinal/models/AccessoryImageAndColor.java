package ChallengeFinal.models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class AccessoryImageAndColor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name ="native", strategy = "native")
    private long id;
    @ElementCollection
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @Column(name = "links_image", length = 2000)
    private List<String> linkImage;
    private String accessoryColor;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accessory_id")
    private Accessory accessory;

    public AccessoryImageAndColor() {
    }

    public AccessoryImageAndColor(List<String> linkImage, String accessoryColor) {
        this.linkImage = linkImage;
        this.accessoryColor = accessoryColor;
    }

    public long getId() {
        return id;
    }


    public List<String> getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(List<String> linkImage) {
        this.linkImage = linkImage;
    }

    public String getAccessoryColor() {
        return accessoryColor;
    }

    public void setAccessoryColor(String accessoryColor) {
        this.accessoryColor = accessoryColor;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }
}
