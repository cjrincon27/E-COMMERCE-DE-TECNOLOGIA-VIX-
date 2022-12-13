package ChallengeFinal.service.implement;

import ChallengeFinal.dtos.ShoppingCartDTO;
import ChallengeFinal.models.ShoppingCart;
import ChallengeFinal.repository.ShoppingCartRepository;
import ChallengeFinal.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartImplement implements ShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Override
    public List<ShoppingCartDTO> getShoppingCartsDTO() {
        return shoppingCartRepository.findAll().stream().map(shoppingCart -> new ShoppingCartDTO(shoppingCart)).collect(Collectors.toList());
    }

    @Override
    public void save(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }
}
