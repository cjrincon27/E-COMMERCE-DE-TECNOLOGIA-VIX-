package ChallengeFinal.dtos;

import ChallengeFinal.models.Phone;
import ChallengeFinal.models.PhoneImageAndColor;

import java.util.List;

public class PhoneImageAndColorDTO {
    private long id;
    private List<String> linkImage;
    private String phoneColor;
    private long phoneId;

    public PhoneImageAndColorDTO(PhoneImageAndColor phoneImageAndColor) {
        this.id = phoneImageAndColor.getId();
        this.linkImage = phoneImageAndColor.getLinkImage();
        this.phoneColor = phoneImageAndColor.getPhoneColor();
        this.phoneId = phoneImageAndColor.getPhone().getId();
    }

    public long getId() {
        return id;
    }

    public List<String> getLinkImage() {
        return linkImage;
    }

    public String getPhoneColor() {
        return phoneColor;
    }

    public long getPhone() {
        return phoneId;
    }
}
