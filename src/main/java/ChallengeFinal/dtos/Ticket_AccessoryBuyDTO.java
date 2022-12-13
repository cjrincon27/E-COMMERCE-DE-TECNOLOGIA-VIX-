package ChallengeFinal.dtos;

import java.util.List;

public class Ticket_AccessoryBuyDTO {
    private List<Integer> stocks;
    private List<Long> accessoriesId;
    private String color;

    public List<Integer> getStocks() {
        return stocks;
    }

    public List<Long> getAccessoriesId() {
        return accessoriesId;
    }

    public String getColor() {
        return color;
    }
}
