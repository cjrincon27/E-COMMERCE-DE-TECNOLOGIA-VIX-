package ChallengeFinal.service;

import ChallengeFinal.dtos.BuyerDTO;
import ChallengeFinal.models.Buyer;

import java.util.List;

public interface BuyerService {
    public List<BuyerDTO> getBuyersDTO();

    public Buyer findById(long id);

    public Buyer findByEmail(String email);

    public void saveBuyer(Buyer buyer);
    public void deleteBuyer(long buyerId);
}
