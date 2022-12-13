package ChallengeFinal.service;

import ChallengeFinal.dtos.ShoppingCartDTO;
import ChallengeFinal.models.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    public List<ShoppingCartDTO> getShoppingCartsDTO();
    public void save(ShoppingCart shoppingCart);
}
