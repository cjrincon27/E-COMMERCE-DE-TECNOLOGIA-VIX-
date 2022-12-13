package ChallengeFinal.controller;

import ChallengeFinal.dtos.BuyerDTO;
import ChallengeFinal.models.*;
import ChallengeFinal.repository.*;
import ChallengeFinal.service.BuyerService;
import ChallengeFinal.service.EmailService;
import ChallengeFinal.service.PdfService;
import ChallengeFinal.service.TicketPurchaseService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class BuyerController {
    @Autowired
    BuyerService buyerService;
    @Autowired
    TicketPurchaseService ticketPurchaseService;
    @Autowired
    EmailService emailService;
    @Autowired
    PdfService pdfService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/api/buyer")
    public List<BuyerDTO> getBuyersDTO() {
        return buyerService.getBuyersDTO();
    }

    @GetMapping("/api/buyer/current")
    public BuyerDTO getAllBuyersDTO(Authentication authentication) {
        return new BuyerDTO(buyerService.findByEmail(authentication.getName()));
    }

    @PostMapping("/api/buyer")
    public ResponseEntity<?> createBuyer(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password
    ) {
        if (firstName.isEmpty()) {
            return new ResponseEntity<>("fistName is empty", HttpStatus.FORBIDDEN);
        }
        if (lastName.isEmpty()) {
            return new ResponseEntity<>("fistName is empty", HttpStatus.FORBIDDEN);
        }
        if (email.isEmpty()) {
            return new ResponseEntity<>("fistName is empty", HttpStatus.FORBIDDEN);
        }
        if (password.isEmpty()) {
            return new ResponseEntity<>("fistName is empty", HttpStatus.FORBIDDEN);
        }
        if (buyerService.findByEmail(email) != null) {
            return new ResponseEntity<>("email already in use", HttpStatus.FORBIDDEN);
        }
        Buyer newBuyer = new Buyer(firstName, lastName, email, passwordEncoder.encode(password));
        buyerService.saveBuyer(newBuyer);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Buyer checkBuyer = buyerService.findByEmail(email);
                if (!checkBuyer.isValidator()) {
                    buyerService.deleteBuyer(checkBuyer.getId());
                }
            }
        };
        timer.schedule(timerTask, 60000 * 30);
        return new ResponseEntity<>(newBuyer.getCode(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/api/buyer/ticket")
    public ResponseEntity<?> addTicketToBuyer(
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());

        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }

        ShoppingCart shoppingCartCurrent = buyerCurrent.getShoppingCart();
        TicketPurchase newTicketPurchase = new TicketPurchase(LocalDateTime.now(), LocalDateTime.now().plusMonths(1));

        if (shoppingCartCurrent.getTicketPhone_carts().size() > 0) {
            List<Ticket_Phone> ticket_phoneList = shoppingCartCurrent.getTicketPhone_carts().stream().map(ticketPhone_cart -> ticketPhone_cart.getTicket_phone()).collect(Collectors.toList());
            for (int i = 0; i < ticket_phoneList.size(); i++) {
                Ticket_Phone ticket_phone = ticket_phoneList.get(i);
                newTicketPurchase.addTicketPhone(ticket_phone);
                Phone phone = ticket_phone.getPhone();
                if (phone.getStock() < ticket_phone.getStock()) {
                    return new ResponseEntity<>("the stock pruchase is higher a stock phone", HttpStatus.FORBIDDEN);
                }
                phone.setStock(phone.getStock() - ticket_phone.getStock());
            }
        }
        if (shoppingCartCurrent.getTicketConsole_carts().size() > 0) {
            List<Ticket_Console> ticket_consoleList = shoppingCartCurrent.getTicketConsole_carts().stream().map(ticketConsole_cart -> ticketConsole_cart.getTicket_console()).collect(Collectors.toList());
            for (int i = 0; i < ticket_consoleList.size(); i++) {
                Ticket_Console ticket_console = ticket_consoleList.get(i);
                newTicketPurchase.addTicketConsole(ticket_console);
                Console console = ticket_console.getConsole();
                if (console.getStock() < ticket_console.getStock()) {
                    return new ResponseEntity<>("the stock pruchase is higher a stock console", HttpStatus.FORBIDDEN);
                }
                console.setStock(console.getStock() - ticket_console.getStock());
            }
        }
        if (shoppingCartCurrent.getTicketAccessory_carts().size() > 0) {
            List<Ticket_Accessory> ticket_accessoryList = shoppingCartCurrent.getTicketAccessory_carts().stream().map(ticketAccessory_cart -> ticketAccessory_cart.getTicket_accessory()).collect(Collectors.toList());
            for (int i = 0; i < ticket_accessoryList.size(); i++) {
                Ticket_Accessory ticket_accessory = ticket_accessoryList.get(i);
                newTicketPurchase.addTicketAccessory(ticket_accessory);
                Accessory accessory = ticket_accessory.getAccessory();
                if (accessory.getStock() < ticket_accessory.getStock()) {
                    return new ResponseEntity<>("the stock pruchase is higher a stock accessory", HttpStatus.FORBIDDEN);
                }
                accessory.setStock(accessory.getStock() - ticket_accessory.getStock());
            }
        }
        buyerCurrent.addTicketPurchase(newTicketPurchase);
        buyerService.saveBuyer(buyerCurrent);
        ticketPurchaseService.saveTicketPurchase(newTicketPurchase);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/api/buyer")
    public ResponseEntity<?> changePassword(
            @RequestParam String password,
            Authentication authentication
    ) {
        if (password.isEmpty()) {
            return new ResponseEntity<>("password is empty", HttpStatus.FORBIDDEN);
        }

        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (password.equals(buyerCurrent.getPassword())) {
            return new ResponseEntity<>("new password is equal a old password", HttpStatus.FORBIDDEN);
        }
        buyerCurrent.setPassword(password);
        buyerService.saveBuyer(buyerCurrent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/buyer/email")
    public ResponseEntity<Object> sendEmailTool(
            @RequestParam String to,
            @RequestParam int code

    ) {
        String textMessage = "the validation code is                                                                                                            " +
                code;
        String subject = "Validation email";
        emailService.sendEmailTool(textMessage, to, subject);

        return new ResponseEntity<>("Message sent", HttpStatus.ACCEPTED);

    }

    @PatchMapping("/api/validation/buyer")
    public ResponseEntity<Object> validation(
            @RequestParam String email,
            @RequestParam int code
    ) {
        Buyer current = buyerService.findByEmail(email);
        if (current.getCode() == code) {
            current.setValidator(true);
            buyerService.saveBuyer(current);
        }
        return new ResponseEntity<>("Correct code log in", HttpStatus.ACCEPTED);
    }

    @GetMapping("/api/buyer/pdf")
    public void pdf(HttpServletResponse response,
                    Authentication authentication) throws DocumentException, IOException {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());

//        TicketPurchase ticketPurchases = ticketPurchaseService.findById(purchaseId);

        int sizeTicketPurchase = buyerCurrent.getTicketPurchases().size();
        List<TicketPurchase> ticketPurchases = new ArrayList<>(buyerCurrent.getTicketPurchases());

        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValues = "attachment; filename=Purchase_" + buyerCurrent.getFirstName() + "_" + buyerCurrent.getLastName() + ".pdf";
        response.setHeader(headerKey, headerValues);

        pdfService.export(buyerCurrent, ticketPurchases.get(sizeTicketPurchase - 1), response);
    }

}
