package ChallengeFinal.controller;

import ChallengeFinal.dtos.AccessoryDTO;
import ChallengeFinal.dtos.NewAccessoryDTO;
import ChallengeFinal.models.*;
import ChallengeFinal.service.AccessoryImageAndColorService;
import ChallengeFinal.service.AccessoryService;
import ChallengeFinal.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static ChallengeFinal.models.AccesoryType.*;

@RestController
public class AccessoryController {
    @Autowired
    AccessoryService accessoryService;
    @Autowired
    AccessoryImageAndColorService accessoryImageAndColorService;
    @Autowired
    BuyerService buyerService;

    @GetMapping("/api/accessory")
    public List<AccessoryDTO> getAccessoryDTO() {
        return accessoryService.getAccessoryDTO();
    }

    @GetMapping("/api/accessory/page")
    public Page<AccessoryDTO> getAccessoryDTOPage(@PageableDefault(value = 9) Pageable pageable) {
        return accessoryService.getAccessoryDTOPage(pageable);
    }

    @PostMapping("/api/accessory")
    public ResponseEntity<?> createAccessory(
            @RequestBody NewAccessoryDTO newAccessory,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (newAccessory == null) {
            return new ResponseEntity<>("newAccessory is null", HttpStatus.FORBIDDEN);
        }

        String description = newAccessory.getDescription();
        String type = newAccessory.getType();
        String brand = newAccessory.getBrand();
        String model = newAccessory.getModel();
        int stock = newAccessory.getStock();
        Double price = newAccessory.getPrice();
        List<String> linkImage = newAccessory.getLinkImage();
        String accessoryColor = newAccessory.getAccessoryColor();
        if (description.isEmpty()) {
            return new ResponseEntity<>("Accessory description is empty\"", HttpStatus.FORBIDDEN);
        }
        if (type.isEmpty()) {
            return new ResponseEntity<>("Accessory type is empty\"", HttpStatus.FORBIDDEN);
        }
        if (!type.equals("HEADPHONE") && !type.equals("CONSOLE") && !type.equals("CHARGER") && !type.equals("PHONECASE")) {
            return new ResponseEntity<>("Accessory type only be CHARGER;PHONECASE;CONSOLE;HEADPHONE", HttpStatus.FORBIDDEN);
        }
        if (brand.isEmpty()) {
            return new ResponseEntity<>("Accessory brand is empty", HttpStatus.FORBIDDEN);
        }
        if (model.isEmpty()) {
            return new ResponseEntity<>("Accessory model is empty", HttpStatus.FORBIDDEN);
        }
        if (stock <= 0) {
            return new ResponseEntity<>("Accessory stock is equal 0", HttpStatus.FORBIDDEN);
        }
        if (price <= 0 || price.isNaN()) {
            return new ResponseEntity<>("Accessory price is equal 0", HttpStatus.FORBIDDEN);
        }
        if (linkImage.size() == 0) {
            return new ResponseEntity<>("Accessory links images is equal 0", HttpStatus.FORBIDDEN);
        }
        if (accessoryColor.isEmpty()) {
            return new ResponseEntity<>("Accessory color is empty", HttpStatus.FORBIDDEN);
        }
        AccesoryType accesoryType = null;
        if (type.equals("HEADPHONE")) {
            accesoryType = AccesoryType.HEADPHONE;
        }
        if (type.equals("CONSOLE")) {
            accesoryType = ACC_CONSOLE;
        }
        if (type.equals("CHARGER")) {
            accesoryType = CHARGER;
        }
        if (type.equals("PHONECASE")) {
            accesoryType = PHONECASE;
        }
        Accessory accessoryNew = new Accessory(description, accesoryType, brand, model, stock, price);//1
        accessoryService.saveAccessory(accessoryNew);//2
        AccessoryImageAndColor newAccessoryImageAndColor = new AccessoryImageAndColor(linkImage, accessoryColor);//3
        accessoryNew.addImagesAndColor(newAccessoryImageAndColor);//4
        accessoryImageAndColorService.saveAccessoryImageAndColor(newAccessoryImageAndColor);//5

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/accessory/delete")
    public ResponseEntity<?> deleteAccessory(
            @RequestParam long accessoryId,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (accessoryId <= 0) {
            return new ResponseEntity<>("AccessoryId is empty", HttpStatus.FORBIDDEN);
        }
        Accessory accessoryDelete = accessoryService.findById(accessoryId);
        if (accessoryDelete == null) {
            return new ResponseEntity<>("the accessory with that id did not exist", HttpStatus.FORBIDDEN);
        }

        accessoryDelete.setEnable(false);
        accessoryService.saveAccessory(accessoryDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/accessory/type")
    public List<AccesoryType> getTypesAccessory() {
        return new ArrayList<>(List.of(ACC_CONSOLE,
                CHARGER,
                SMARTWATCH,
                HEADPHONE,
                PHONECASE));
    }

    @PatchMapping("/api/accessory/stock")
    public ResponseEntity<?> setterStock(
            @RequestParam int stock,
            @RequestParam long accessoryId,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (stock <= 0) {
            return new ResponseEntity<>("stock is equal to 0", HttpStatus.FORBIDDEN);
        }
        if (accessoryId <= 0) {
            return new ResponseEntity<>("accessory is equal to 0", HttpStatus.FORBIDDEN);
        }
        Accessory foundAccessory = accessoryService.findById(accessoryId);
        if (foundAccessory == null) {
            return new ResponseEntity<>("accessory with accessoryId is null", HttpStatus.FORBIDDEN);
        }
        foundAccessory.setStock(stock);
        accessoryService.saveAccessory(foundAccessory);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/api/accessory/price")
    public ResponseEntity<?> setterPrice(
            @RequestParam double price,
            @RequestParam long accessoryId,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (price <= 0) {
            return new ResponseEntity<>("stock is equal to 0", HttpStatus.FORBIDDEN);
        }
        if (accessoryId <= 0) {
            return new ResponseEntity<>("accessory is equal to 0", HttpStatus.FORBIDDEN);
        }
        Accessory foundAccessory = accessoryService.findById(accessoryId);
        if (foundAccessory == null) {
            return new ResponseEntity<>("accessory with accessoryId is null", HttpStatus.FORBIDDEN);
        }
        foundAccessory.setPrice(price);
        accessoryService.saveAccessory(foundAccessory);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
