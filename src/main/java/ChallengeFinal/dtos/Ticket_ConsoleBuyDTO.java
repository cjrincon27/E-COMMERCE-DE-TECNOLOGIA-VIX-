package ChallengeFinal.dtos;

import java.util.List;

public class Ticket_ConsoleBuyDTO {
    private List<Integer> stocks;
    private List<Long> consolesId;

    public List<Integer> getStocks() {
        return stocks;
    }

    public List<Long> getConsolesId() {
        return consolesId;
    }
}
