package ChallengeFinal.service.implement;

import ChallengeFinal.dtos.BuyerDTO;
import ChallengeFinal.models.Buyer;
import ChallengeFinal.repository.BuyerRepository;
import ChallengeFinal.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuyerImplement implements BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    @Override
    public List<BuyerDTO> getBuyersDTO() {
        return buyerRepository.findAll().stream().filter(buyer -> buyer.isValidator() == true).map(buyer -> new BuyerDTO(buyer)).collect(Collectors.toList());
    }

    @Override
    public Buyer findById(long id) {
        return buyerRepository.findById(id).orElse(null);
    }

    @Override
    public Buyer findByEmail(String email) {
        return buyerRepository.findByEmail(email);
    }

    @Override
    public void saveBuyer(Buyer buyer) {
        buyerRepository.save(buyer);
    }

    @Override
    public void deleteBuyer(long buyerId) {
        buyerRepository.deleteById(buyerId);
    }
}
