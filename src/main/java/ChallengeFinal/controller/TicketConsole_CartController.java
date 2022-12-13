package ChallengeFinal.controller;

import ChallengeFinal.dtos.TicketConsole_CartDTO;
import ChallengeFinal.dtos.Ticket_ConsoleBuyDTO;
import ChallengeFinal.models.*;
import ChallengeFinal.repository.ShoppingCartRepository;
import ChallengeFinal.repository.TicketConsole_CartRepository;
import ChallengeFinal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TicketConsole_CartController {
    @Autowired
    TicketConsole_CartService ticketConsole_CartService;
    @Autowired
    BuyerService buyerService;
    @Autowired
    ConsoleService consoleService;
    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    Ticket_ConsoleService ticket_consoleService;

    @GetMapping("/api/ticket/console/cart")
    public List<TicketConsole_CartDTO> ticketConosle_cartDTOS() {
        return ticketConsole_CartService.ticketConsole_cartDTOS();
    }

    @PostMapping("/api/ticket/console/cart")
    public ResponseEntity<?> addTicketConsole(
            @RequestBody Ticket_ConsoleBuyDTO consolesBuy,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (consolesBuy == null) {
            return new ResponseEntity<>("consolesBuy is empty", HttpStatus.FORBIDDEN);
        }
        ShoppingCart shoppingCartCurrent = buyerCurrent.getShoppingCart();
        List<Integer> consolesStock = consolesBuy.getStocks();
        List<Long> consolesId = consolesBuy.getConsolesId();
//        List<Console> consoles = consoleService.findAll();
        List<Long> ticket_ConsolelistId = shoppingCartCurrent.getTicketConsole_carts().stream().map(ticketConsole_cart -> ticketConsole_cart.getTicket_console().getConsole().getId()).collect(Collectors.toList());
        if (ticket_ConsolelistId.contains(consolesId.get(0))) {
            List<TicketConsole_Cart> ticketConsole_carts = shoppingCartCurrent.getTicketConsole_carts().stream().filter(ticketConsole_cart -> ticketConsole_cart.getTicket_console().getConsole().getId() == consolesId.get(0)).collect(Collectors.toList());
            Ticket_Console ticket_console = ticketConsole_carts.get(0).getTicket_console();
            ticket_console.setStock(ticket_console.getStock() + 1);
            ticket_consoleService.saveTicket_Console(ticket_console);
        } else {
            if (consolesStock == null || consolesStock.isEmpty()) {
                return new ResponseEntity<>("consolesStock is null", HttpStatus.FORBIDDEN);
            }
            for (int i = 0; i < consolesId.size() && i < consolesStock.size(); i++) {
                Integer stock = consolesStock.get(i);
                Console console = consoleService.findById(consolesId.get(i));
                ;
                Ticket_Console newTicket_console = new Ticket_Console(console, stock);
                TicketConsole_Cart newTicketConsole_cart = new TicketConsole_Cart(newTicket_console, shoppingCartCurrent);
                ticket_consoleService.saveTicket_Console(newTicket_console);
                ticketConsole_CartService.save(newTicketConsole_cart);
            }
        }
        shoppingCartService.save(shoppingCartCurrent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/api/ticket/console/cart")
    public ResponseEntity<?> setterStock(
            @RequestParam long idTicketConsole_Cart,
            @RequestParam int stock,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (idTicketConsole_Cart <= 0) {
            return new ResponseEntity<>("idTicketPhone_Cart is null", HttpStatus.FORBIDDEN);
        }
        if (stock <= 0) {
            return new ResponseEntity<>("stock is null", HttpStatus.FORBIDDEN);
        }
        ShoppingCart shoppingCartCurrent = buyerCurrent.getShoppingCart();

        TicketConsole_Cart ticketConsole_cart = ticketConsole_CartService.findById(idTicketConsole_Cart);
        if (ticketConsole_cart == null) {
            return new ResponseEntity<>("ticketConsole_cart is null", HttpStatus.FORBIDDEN);
        }
        if (!shoppingCartCurrent.getTicketConsole_carts().contains(ticketConsole_cart)) {
            return new ResponseEntity<>("ticketConsole_cart don't is you", HttpStatus.FORBIDDEN);
        }
        Ticket_Console ticket_console = ticketConsole_cart.getTicket_console();
        if (ticket_console.getConsole().getStock() < stock) {
            return new ResponseEntity<>("the stock required is higher to the allowed", HttpStatus.FORBIDDEN);
        }
        ticket_console.setStock(stock);
        ticket_consoleService.saveTicket_Console(ticket_console);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/api/ticket/console/cart/delete")
    public ResponseEntity<?> removeTicketConsoleCart(
            @RequestParam long ticketConsoleCartId,
            Authentication authentication
    ){
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (ticketConsoleCartId <= 0 ){
            return new ResponseEntity<>("ticketConsoleCartId is null", HttpStatus.FORBIDDEN);
        }
        ShoppingCart shoppingCartCurrent = buyerCurrent.getShoppingCart();
        TicketConsole_Cart ticketConsole_cart= ticketConsole_CartService.findById(ticketConsoleCartId);
        List<TicketConsole_Cart> ticketConsole_carts = shoppingCartCurrent.getTicketConsole_carts();
        if (!ticketConsole_carts.contains(ticketConsole_cart)){
            return new ResponseEntity<>("ticketConsoleCart don't is you", HttpStatus.FORBIDDEN);
        }
        shoppingCartCurrent.getTicketConsole_carts().remove(ticketConsole_cart);
        ticketConsole_CartService.deleteById(ticketConsole_cart.getId());
        shoppingCartService.save(shoppingCartCurrent);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
