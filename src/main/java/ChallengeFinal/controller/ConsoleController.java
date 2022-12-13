package ChallengeFinal.controller;

import ChallengeFinal.dtos.ConsoleDTO;
import ChallengeFinal.dtos.NewConsoleDTO;
import ChallengeFinal.models.*;
import ChallengeFinal.repository.ConsoleRepository;
import ChallengeFinal.repository.Ticket_ConsoleRepository;
import ChallengeFinal.service.BuyerService;
import ChallengeFinal.service.ConsoleService;
import ChallengeFinal.service.Ticket_ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class ConsoleController {
    @Autowired
    ConsoleService consoleService;
    @Autowired
    BuyerService buyerService;

    @GetMapping("/api/console")
    public List<ConsoleDTO> consolesDTO() {
        return consoleService.consolesDTO();
    }

    @PostMapping("/api/console")
    public ResponseEntity<?> createConsole(
            @RequestBody NewConsoleDTO newConsoleDTO,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (newConsoleDTO == null) {
            return new ResponseEntity<>("newConsoleDTO is null", HttpStatus.FORBIDDEN);
        }
        String brand = newConsoleDTO.getBrand();
        String model = newConsoleDTO.getModel();
        double price = newConsoleDTO.getPrice();
        int stock = newConsoleDTO.getStock();
        String ram = newConsoleDTO.getRam();
        String rom = newConsoleDTO.getRom();
        String controls = newConsoleDTO.getControls();
        String description = newConsoleDTO.getDescription();
        List<String> images = newConsoleDTO.getImages();
        String imageBg = newConsoleDTO.getImageBg();
        if (brand.isEmpty()) {
            return new ResponseEntity<>("brand is empty", HttpStatus.FORBIDDEN);
        }
        if (model.isEmpty()) {
            return new ResponseEntity<>("model is empty", HttpStatus.FORBIDDEN);
        }
        if (price <= 0) {
            return new ResponseEntity<>("price is equal to 0", HttpStatus.FORBIDDEN);
        }
        if (stock <= 0) {
            return new ResponseEntity<>("stock is equal to 0", HttpStatus.FORBIDDEN);
        }
        if (ram.isEmpty()) {
            return new ResponseEntity<>("ram is empty", HttpStatus.FORBIDDEN);
        }
        if (rom.isEmpty()) {
            return new ResponseEntity<>("rom is empty", HttpStatus.FORBIDDEN);
        }
        if (controls.isEmpty()) {
            return new ResponseEntity<>("controls is empty", HttpStatus.FORBIDDEN);
        }
        if (description.isEmpty()) {
            return new ResponseEntity<>("description is empty", HttpStatus.FORBIDDEN);
        }
        if (images.size() == 0) {
            return new ResponseEntity<>("images size is equal to 0", HttpStatus.FORBIDDEN);
        }
        if (imageBg.isEmpty()) {
            return new ResponseEntity<>("imageBg is empty", HttpStatus.FORBIDDEN);
        }
        Console newConsole = new Console(brand, model, price, stock, ram, rom, controls, description, imageBg);
        for (int i = 0; i < images.size(); i++) {
            String image = images.get(i);
            newConsole.addImage(image);
        }
        consoleService.saveConsole(newConsole);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/console/delete")
    public ResponseEntity<?> deleteConsole(
            @RequestParam long consoleId,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (consoleId <= 0) {
            return new ResponseEntity<>("consoleId is equal to 0", HttpStatus.FORBIDDEN);
        }
        Console consoleDelete = consoleService.findById(consoleId);
        if (consoleDelete == null) {
            return new ResponseEntity<>("console with consoleId is null", HttpStatus.FORBIDDEN);
        }
        if (consoleId > 0) {
            consoleDelete.setEnable(false);
            consoleService.saveConsole(consoleDelete);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/api/console/stock")
    public ResponseEntity<?> setterStock(
            @RequestParam int stock,
            @RequestParam long consoleId,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (stock <= 0) {
            return new ResponseEntity<>("stock is equal to 0", HttpStatus.FORBIDDEN);
        }
        if (consoleId <= 0) {
            return new ResponseEntity<>("accessory is equal to 0", HttpStatus.FORBIDDEN);
        }
        Console foundConsole = consoleService.findById(consoleId);
        if (foundConsole == null) {
            return new ResponseEntity<>("accessory with accessoryId is null", HttpStatus.FORBIDDEN);
        }
        foundConsole.setStock(stock);
        consoleService.saveConsole(foundConsole);


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/api/console/price")
    public ResponseEntity<?> setterPrice(
            @RequestParam double price,
            @RequestParam long consoleId,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (price <= 0) {
            return new ResponseEntity<>("stock is equal to 0", HttpStatus.FORBIDDEN);
        }
        if (consoleId <= 0) {
            return new ResponseEntity<>("accessory is equal to 0", HttpStatus.FORBIDDEN);
        }
        Console foundConsole = consoleService.findById(consoleId);
        if (foundConsole == null) {
            return new ResponseEntity<>("accessory with accessoryId is null", HttpStatus.FORBIDDEN);
        }
        foundConsole.setPrice(price);
        consoleService.saveConsole(foundConsole);

        return new ResponseEntity<>(HttpStatus.OK);
    }
};
