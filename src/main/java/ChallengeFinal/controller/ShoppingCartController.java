package ChallengeFinal.controller;

import ChallengeFinal.dtos.ShoppingCartDTO;
import ChallengeFinal.models.*;
import ChallengeFinal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    BuyerService buyerService;
    @Autowired
    TicketAccessory_CartService ticketAccessory_CartService;
    @Autowired
    TicketPhone_CartService ticketPhone_CartService;
    @Autowired
    TicketConsole_CartService ticketConsole_CartService;

    @GetMapping("/api/cart")
    public List<ShoppingCartDTO> getShoppingCarts() {
        return shoppingCartService.getShoppingCartsDTO();
    }
    @PutMapping("/api/cart")
    public ResponseEntity<?> voidShoppingCart(
            Authentication authentication
    ){
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        ShoppingCart shoppingCart = buyerCurrent.getShoppingCart();
        if (shoppingCart == null){
            return new ResponseEntity<>("shoppingCart is null", HttpStatus.FORBIDDEN);
        }
        List<TicketConsole_Cart> ticketConsole_carts= shoppingCart.getTicketConsole_carts();
        if (ticketConsole_carts.size() > 0){
            for (int i = 0 ; i < ticketConsole_carts.size(); i ++){
                TicketConsole_Cart ticketConsole_cart = ticketConsole_carts.get(i);
                ticketConsole_CartService.deleteById(ticketConsole_cart.getId());
            }
        }

        List<TicketAccessory_Cart> ticketAccessory_carts = shoppingCart.getTicketAccessory_carts();
        if (ticketAccessory_carts.size() > 0){
            for (int i = 0 ; i < ticketAccessory_carts.size(); i ++){
                TicketAccessory_Cart ticketAccessory_cart = ticketAccessory_carts.get(i);
                ticketAccessory_CartService.deleteById(ticketAccessory_cart.getId());
            }
        }

        List<TicketPhone_Cart> ticketPhone_carts = shoppingCart.getTicketPhone_carts();
        if (ticketPhone_carts.size() > 0){
            for (int i = 0 ; i < ticketPhone_carts.size(); i ++){
                TicketPhone_Cart ticketPhone_cart = ticketPhone_carts.get(i);
                ticketPhone_CartService.deleteById(ticketPhone_cart.getId());
        }

        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}