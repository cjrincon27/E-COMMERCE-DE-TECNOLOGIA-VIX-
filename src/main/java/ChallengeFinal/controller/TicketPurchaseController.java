package ChallengeFinal.controller;

import ChallengeFinal.dtos.TicketPurchaseDTO;
import ChallengeFinal.dtos.Ticket_AccessoryBuyDTO;
import ChallengeFinal.dtos.Ticket_ConsoleBuyDTO;
import ChallengeFinal.dtos.Ticket_PhoneBuyDTO;
import ChallengeFinal.models.*;
import ChallengeFinal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TicketPurchaseController {
    @Autowired
    TicketPurchaseService ticketPurchaseService;
    @Autowired
    PhoneService phoneService;
    @Autowired
    AccessoryService accessoryService;
    @Autowired
    Ticket_AccessoryService ticket_AccessoryService;
    @Autowired
    Ticket_PhoneService ticket_PhoneService;
    @Autowired
    Ticket_ConsoleService ticket_ConsoleService;
    @Autowired
    ConsoleService consoleService;
    @Autowired
    BuyerService buyerService;

    @GetMapping("/api/ticket")
    public List<TicketPurchaseDTO> getTicketPurchaseDTOS() {
        return ticketPurchaseService.getTicketPurchaseDTOS();
    }

//    @PostMapping("/api/ticket")
//    public ResponseEntity<?> makeATicketPurchase(
//            @RequestBody(required = false) Ticket_PhoneBuyDTO phonesBuy,
//            @RequestBody(required = false) Ticket_AccessoryBuyDTO accessoriesBuy,
//            @RequestBody(required = false) Ticket_ConsoleBuyDTO consolesBuy,
//            Authentication authentication
//    ) {
//        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
//        if (buyerCurrent == null) {
//            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
//        }
//        TicketPurchase ticketPurchase = new TicketPurchase(LocalDateTime.now(), LocalDateTime.now().plusMonths(1));
//        List<Integer> phonesStock;
//        List<Integer> accessoriesStock;
//        List<Integer> consolesStock;
//        List<Long> phonesId;
//        List<Long> accessoriesId;
//        List<Long> consolesId;
//        List<Phone> phones = phoneService.findAll();
//        List<Accessory> accessories = accessoryService.findAll();
//        List<Console> consoles = consoleService.findAll();
//
//        if (phonesBuy == null && accessoriesBuy == null & consolesBuy == null) {
//            return new ResponseEntity<>("all params are empty", HttpStatus.FORBIDDEN);
//        }
//        if (phonesBuy != null) {
//            phonesStock = phonesBuy.getStocks();
//            phonesId = phonesBuy.getPhonesId();
//            if (phonesStock == null || phonesStock.isEmpty()) {
//                return new ResponseEntity<>("phonesStock is null", HttpStatus.FORBIDDEN);
//            }
//            if (phonesId == null || phonesId.isEmpty()) {
//                return new ResponseEntity<>("phonesId is null", HttpStatus.FORBIDDEN);
//            }
//            for (int i = 0; i < phonesId.size() && i < phonesStock.size(); i++) {
//                Integer stock = phonesStock.get(i);
//                Phone phone = phones.get(Math.toIntExact(phonesId.get(i)));
//                Ticket_Phone newTicket_Phone = new Ticket_Phone(phone, stock);
//                ticketPurchase.addTicketPhone(newTicket_Phone);
//                ticket_PhoneService.saveTicket_Phone(newTicket_Phone);
//            }
//        }
//        if (accessoriesBuy != null) {
//            accessoriesStock = accessoriesBuy.getStocks();
//            accessoriesId = accessoriesBuy.getAccessoriesId();
//            if (accessoriesStock == null || accessoriesStock.isEmpty()) {
//                return new ResponseEntity<>("accessoriesStock is null", HttpStatus.FORBIDDEN);
//            }
//            if (accessoriesId == null || accessoriesId.isEmpty()) {
//                return new ResponseEntity<>("accessoriesId is null", HttpStatus.FORBIDDEN);
//            }
//            for (int i = 0; i < accessoriesId.size() && i < accessoriesStock.size(); i++) {
//                Integer stock = accessoriesStock.get(i);
//                Accessory accessory = accessories.get(Math.toIntExact(accessoriesId.get(i)));
//                Ticket_Accessory newTicket_Accessory = new Ticket_Accessory(accessory, stock);
//                ticketPurchase.addTicketAccessory(newTicket_Accessory);
//                ticket_AccessoryService.saveTicket_Accessory(newTicket_Accessory);
//            }
//        }
//        if (consolesBuy != null) {
//            consolesStock = consolesBuy.getStocks();
//            consolesId = consolesBuy.getConsolesId();
//            if (consolesStock == null || consoles.isEmpty()) {
//                return new ResponseEntity<>("consolesStock is null", HttpStatus.FORBIDDEN);
//            }
//            if (consolesId == null || consolesId.isEmpty()) {
//                return new ResponseEntity<>("consolesId is null", HttpStatus.FORBIDDEN);
//            }
//            for (int i = 0; i < consolesId.size() && i < consolesStock.size(); i++) {
//                Integer stock = consolesStock.get(i);
//                Console console = consoles.get(Math.toIntExact(consolesId.get(i)));
//                Ticket_Console newTicket_console = new Ticket_Console(console, stock);
//                ticketPurchase.addTicketConsole(newTicket_console);
//                ticket_ConsoleService.saveTicket_Console(newTicket_console);
//            }
//        }
//        ticketPurchaseService.saveTicketPurchase(ticketPurchase);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @PatchMapping("/api/ticket")
//    public ResponseEntity<?> deleteTicketAccessoryOrTicketPhoneToTicketPurchase(
//            @RequestParam(required = false) long ticketPhoneId,
//            @RequestParam(required = false) long ticketAccessoryId,
//            @RequestParam(required = false) long ticketConsoleId,
//            @RequestParam long ticketPurchaseId,
//            Authentication authentication
//    ) {
//        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
//        if (buyerCurrent == null) {
//            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
//        }
//        TicketPurchase ticketPurchase;
//        Ticket_Accessory ticket_accessory;
//        Ticket_Phone ticket_phone;
//        Ticket_Console ticket_console;
//        if (ticketPhoneId == 0 && ticketAccessoryId == 0 && ticketConsoleId == 0) {
//            return new ResponseEntity<>("all params  Id are equals to 0", HttpStatus.FORBIDDEN);
//        }
//        if (ticketPurchaseId == 0) {
//            return new ResponseEntity<>("ticketPurchaseId is equal to 0", HttpStatus.FORBIDDEN);
//        }
//        ticketPurchase = ticketPurchaseService.findById(ticketPurchaseId);
//
//        if (ticketPurchase == null) {
//            return new ResponseEntity<>("ticketPurchase wirh ticketPurchaseId is null", HttpStatus.FORBIDDEN);
//        }
//        if (ticketAccessoryId != 0) {
//            ticket_accessory = ticket_AccessoryService.findById(ticketAccessoryId);
//            if (ticket_accessory == null) {
//                return new ResponseEntity<>("ticket accesory with ticketAccessoryId is null", HttpStatus.FORBIDDEN);
//            }
//            ticketPurchase.getTicketAccesories().remove(ticket_accessory);
//        }
//        if (ticketPhoneId != 0) {
//            ticket_phone = ticket_PhoneService.findById(ticketPhoneId);
//            if (ticket_phone == null) {
//                return new ResponseEntity<>("ticket phone with ticketPhoneId is null", HttpStatus.FORBIDDEN);
//            }
//            ticketPurchase.getTicketPhones().remove(ticket_phone);
//        }
//        if (ticketConsoleId != 0) {
//            ticket_console = ticket_ConsoleService.findById(ticketConsoleId);
//            if (ticket_console == null) {
//                return new ResponseEntity<>("ticket console with ticketConsoleId is null", HttpStatus.FORBIDDEN);
//            }
//            ticketPurchase.getTicketConsoles().remove(ticket_console);
//        }
//        ticketPurchaseService.saveTicketPurchase(ticketPurchase);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
