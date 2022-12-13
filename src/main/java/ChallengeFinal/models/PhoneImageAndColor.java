package ChallengeFinal.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class PhoneImageAndColor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name ="native", strategy = "native")
    private long id;
    @ElementCollection
    @Column(name = "links_image", length = 2000)
    private List<String> linkImage;
    private String phoneColor;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phone_id")
    private Phone phone;

    public PhoneImageAndColor() {
    }

    public PhoneImageAndColor(List<String> linkImage, String phoneColor) {
        this.linkImage = linkImage;
        this.phoneColor = phoneColor;
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

    public String getPhoneColor() {
        return phoneColor;
    }

    public void setPhoneColor(String phoneColor) {
        this.phoneColor = phoneColor;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
