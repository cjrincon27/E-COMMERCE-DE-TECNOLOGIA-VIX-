package ChallengeFinal.controller;

import ChallengeFinal.dtos.TicketAccessory_CartDTO;
import ChallengeFinal.dtos.Ticket_AccessoryBuyDTO;
import ChallengeFinal.models.*;
import ChallengeFinal.repository.ShoppingCartRepository;
import ChallengeFinal.repository.TicketAccessory_CartRepository;
import ChallengeFinal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TicketAccessory_CartController {
    @Autowired
    TicketAccessory_CartService ticketAccessory_cartService;
    @Autowired
    AccessoryService accessoryService;
    @Autowired
    Ticket_AccessoryService ticket_accessoryService;
    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    BuyerService buyerService;

    @GetMapping("/api/ticket/accessory/cart")
    public List<TicketAccessory_CartDTO> getTicketAccessory_cartDTOS() {
        return ticketAccessory_cartService.getTicketAccessory_cartDTOS();
    }


    @PostMapping("/api/ticket/accessory/cart")
    public ResponseEntity<?> addTicketAccessory(
            @RequestBody Ticket_AccessoryBuyDTO accessoriesBuy,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (accessoriesBuy == null) {
            return new ResponseEntity<>("accessoriesBuy is empty", HttpStatus.FORBIDDEN);
        }
        ShoppingCart shoppingCartCurrent = buyerCurrent.getShoppingCart();
        List<Integer> accessoriesStock = accessoriesBuy.getStocks();
        List<Long> accessoriesId = accessoriesBuy.getAccessoriesId();
        String color = accessoriesBuy.getColor();
        List<Long> ticket_accessoryListID = shoppingCartCurrent.getTicketAccessory_carts().stream().map(ticketAccessory_cart -> ticketAccessory_cart.getTicket_accessory().getAccessory().getId()).collect(Collectors.toList());
        if (ticket_accessoryListID.contains(accessoriesId.get(0))){
            List<TicketAccessory_Cart> ticketAccessory_carts = shoppingCartCurrent.getTicketAccessory_carts().stream().filter(ticketAccessory_cart -> ticketAccessory_cart.getTicket_accessory().getAccessory().getId() == accessoriesId.get(0)).collect(Collectors.toList());
            Ticket_Accessory ticket_accessory = ticketAccessory_carts.get(0).getTicket_accessory();
            ticket_accessory.setStock(ticket_accessory.getStock() + 1);
            ticket_accessoryService.saveTicket_Accessory(ticket_accessory);
        }else {


            if (accessoriesStock == null || accessoriesStock.isEmpty()) {
                return new ResponseEntity<>("accessoriesStock is null", HttpStatus.FORBIDDEN);
            }
            if (color.isEmpty()){
                return new ResponseEntity<>("color is null", HttpStatus.FORBIDDEN);
            }
            for (int i = 0; i < accessoriesId.size() && i < accessoriesStock.size(); i++) {
                Integer stock = accessoriesStock.get(i);
                Accessory accessory = accessoryService.findById(accessoriesId.get(i));
                Ticket_Accessory newTicket_Accessory = new Ticket_Accessory(accessory, stock, color);
                TicketAccessory_Cart newTicketAccessory_cart = new TicketAccessory_Cart(newTicket_Accessory, shoppingCartCurrent);
                ticket_accessoryService.saveTicket_Accessory(newTicket_Accessory);
                ticketAccessory_cartService.save(newTicketAccessory_cart);
            }
        }
        shoppingCartService.save(shoppingCartCurrent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/api/ticket/accessory/cart")
    public ResponseEntity<?> setterStock(
            @RequestParam long idTicketAccessory_Cart,
            @RequestParam int stock,
            Authentication authentication
    ){
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if(idTicketAccessory_Cart <= 0){
            return new ResponseEntity<>("idTicketPhone_Cart is null", HttpStatus.FORBIDDEN);
        }
        if(stock <= 0){
            return new ResponseEntity<>("stock is null", HttpStatus.FORBIDDEN);
        }
        ShoppingCart shoppingCartCurrent = buyerCurrent.getShoppingCart();

        TicketAccessory_Cart ticketAccessory_cart = ticketAccessory_cartService.findById(idTicketAccessory_Cart);
        if (ticketAccessory_cart == null){
            return new ResponseEntity<>("ticketAccessory_cart is null", HttpStatus.FORBIDDEN);
        }
        if (!shoppingCartCurrent.getTicketAccessory_carts().contains(ticketAccessory_cart)){
            return new ResponseEntity<>("ticketAccessory_cart don't is you", HttpStatus.FORBIDDEN);
        }
        Ticket_Accessory ticket_accessory= ticketAccessory_cart.getTicket_accessory();
        if(ticket_accessory.getAccessory().getStock() < stock){
            return new ResponseEntity<>("the stock required is higher to the allowed", HttpStatus.FORBIDDEN);
        }
        ticket_accessory.setStock(stock);
        ticket_accessoryService.saveTicket_Accessory(ticket_accessory);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/api/ticket/accessory/cart/delete")
    public ResponseEntity<?> removeTicketAccessoryCart(
            @RequestParam long ticketAccessoryCartId,
            Authentication authentication
    ){
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (ticketAccessoryCartId <= 0 ){
            return new ResponseEntity<>("ticketAccessoryCartId is null", HttpStatus.FORBIDDEN);
        }
        ShoppingCart shoppingCartCurrent = buyerCurrent.getShoppingCart();
        TicketAccessory_Cart ticketAccessory_cart= ticketAccessory_cartService.findById(ticketAccessoryCartId);
        List<TicketAccessory_Cart> ticketAccessory_carts = shoppingCartCurrent.getTicketAccessory_carts();
        if (!ticketAccessory_carts.contains(ticketAccessory_cart)){
            return new ResponseEntity<>("ticketAccessory_cart don't is you", HttpStatus.FORBIDDEN);
        }
        shoppingCartCurrent.getTicketAccessory_carts().remove(ticketAccessory_cart);
        ticketAccessory_cartService.deleteById(ticketAccessory_cart.getId());
        shoppingCartService.save(shoppingCartCurrent);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
