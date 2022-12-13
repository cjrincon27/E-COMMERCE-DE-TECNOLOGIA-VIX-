package ChallengeFinal.dtos;

import java.util.List;

public class Ticket_PhoneBuyDTO {
    private List<Integer> stocks;
    private List<Long> phonesId;
    private String color;


    public List<Integer> getStocks() {
        return stocks;
    }

    public List<Long> getPhonesId() {
        return phonesId;
    }

    public String getColor() {
        return color;
    }
}
