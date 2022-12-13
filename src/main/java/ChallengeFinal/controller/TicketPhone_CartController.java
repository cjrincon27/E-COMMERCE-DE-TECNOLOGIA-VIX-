package ChallengeFinal.controller;

import ChallengeFinal.dtos.TicketPhone_CartDTO;
import ChallengeFinal.dtos.Ticket_PhoneBuyDTO;
import ChallengeFinal.models.*;
import ChallengeFinal.repository.ShoppingCartRepository;
import ChallengeFinal.repository.TicketPhone_CarRepository;
import ChallengeFinal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TicketPhone_CartController {
    @Autowired
    TicketPhone_CartService ticketPhone_CartService;
    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    BuyerService buyerService;
    @Autowired
    PhoneService phoneService;
    @Autowired
    Ticket_PhoneService ticket_phoneService;

    @GetMapping("/api/ticket/phone/cart")
    public List<TicketPhone_CartDTO> getTickerPhoner_CartDTO() {
        return ticketPhone_CartService.getTicketPhone_CartDTO();
    }

    @PostMapping("/api/ticket/phone/cart")
    public ResponseEntity<?> addTicketPhone(
            @RequestBody Ticket_PhoneBuyDTO phoneBuyDTO,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (phoneBuyDTO == null) {
            return new ResponseEntity<>("phoneBuyDTO is null", HttpStatus.FORBIDDEN);
        }

        ShoppingCart shoppingCartCurrent = buyerCurrent.getShoppingCart();
        List<Integer> phonesStock = phoneBuyDTO.getStocks();
        List<Long> phonesId = phoneBuyDTO.getPhonesId();
        String color = phoneBuyDTO.getColor();
        List<Long> ticket_phoneListID = shoppingCartCurrent.getTicketPhone_carts().stream().map(ticketPhone_cart -> ticketPhone_cart.getTicket_phone().getPhone().getId()).collect(Collectors.toList());
        if (ticket_phoneListID.contains(phonesId.get(0))){
            List<TicketPhone_Cart> ticketPhone_carts = shoppingCartCurrent.getTicketPhone_carts().stream().filter(ticketPhone_cart -> ticketPhone_cart.getTicket_phone().getPhone().getId() == phonesId.get(0)).collect(Collectors.toList());
            Ticket_Phone ticket_phone = ticketPhone_carts.get(0).getTicket_phone();
            ticket_phone.setStock(ticket_phone.getStock() + 1);
            ticket_phoneService.saveTicket_Phone(ticket_phone);
        }
        else {
            if (phonesStock == null || phonesStock.isEmpty()) {
                return new ResponseEntity<>("phonesStock is null", HttpStatus.FORBIDDEN);
            }
            if (color.isEmpty()){
                return new ResponseEntity<>("color is null", HttpStatus.FORBIDDEN);
            }
            for (int i = 0; i < phonesId.size() && i < phonesStock.size(); i++) {
                Integer stock = phonesStock.get(i);
                Phone phone = phoneService.findById(phonesId.get(i));
                Ticket_Phone newTicket_Phone = new Ticket_Phone(phone, stock, color);
                TicketPhone_Cart newTicketPhone_Cart = new TicketPhone_Cart(newTicket_Phone, shoppingCartCurrent);
                ticket_phoneService.saveTicket_Phone(newTicket_Phone);
                ticketPhone_CartService.save(newTicketPhone_Cart);
            }
        }
        shoppingCartService.save(shoppingCartCurrent);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/api/ticket/phone/cart")
    public ResponseEntity<?> setterStock(
            @RequestParam long idTicketPhone_Cart,
            @RequestParam int stock,
            Authentication authentication
    ){
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if(idTicketPhone_Cart <= 0){
            return new ResponseEntity<>("idTicketPhone_Cart is null", HttpStatus.FORBIDDEN);
        }
        if(stock <= 0){
            return new ResponseEntity<>("stock is null", HttpStatus.FORBIDDEN);
        }
        ShoppingCart shoppingCartCurrent = buyerCurrent.getShoppingCart();

        TicketPhone_Cart ticketPhone_cart = ticketPhone_CartService.findById(idTicketPhone_Cart);
        if (ticketPhone_cart == null){
            return new ResponseEntity<>("ticketPhone_cart is null", HttpStatus.FORBIDDEN);
        }
        if (!shoppingCartCurrent.getTicketPhone_carts().contains(ticketPhone_cart)){
            return new ResponseEntity<>("ticketPhone_cart don't is you", HttpStatus.FORBIDDEN);
        }
        Ticket_Phone ticket_phone = ticketPhone_cart.getTicket_phone();
        if(ticket_phone.getPhone().getStock() < stock){
            return new ResponseEntity<>("the stock required is higher to the allowed", HttpStatus.FORBIDDEN);
        }
        ticket_phone.setStock(stock);
        ticket_phoneService.saveTicket_Phone(ticket_phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/api/ticket/phone/cart/delete")
    public ResponseEntity<?> removeTicketPhoneCart(
            @RequestParam long ticketPhoneCartId,
            Authentication authentication
    ){
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (ticketPhoneCartId <= 0 ){
            return new ResponseEntity<>("ticketPhoneCartId is null", HttpStatus.FORBIDDEN);
        }
        ShoppingCart shoppingCartCurrent = buyerCurrent.getShoppingCart();
        TicketPhone_Cart ticketPhone_cart = ticketPhone_CartService.findById(ticketPhoneCartId);
        List<TicketPhone_Cart> ticketPhone_carts = shoppingCartCurrent.getTicketPhone_carts();
        if (!ticketPhone_carts.contains(ticketPhone_cart)){
            return new ResponseEntity<>("ticketPhoneCart don't is you", HttpStatus.FORBIDDEN);
        }
        shoppingCartCurrent.getTicketPhone_carts().remove(ticketPhone_cart);
        ticketPhone_CartService.deleteById(ticketPhone_cart.getId());
        shoppingCartService.save(shoppingCartCurrent);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
