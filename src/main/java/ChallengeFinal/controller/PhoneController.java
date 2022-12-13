package ChallengeFinal.controller;

import ChallengeFinal.dtos.NewPhoneDTO;
import ChallengeFinal.dtos.PhoneDTO;
import ChallengeFinal.models.Buyer;
import ChallengeFinal.models.Phone;
import ChallengeFinal.models.PhoneImageAndColor;
import ChallengeFinal.service.BuyerService;
import ChallengeFinal.service.PhoneImageAndColorService;
import ChallengeFinal.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PhoneController {
    @Autowired
    PhoneService phoneService;
    @Autowired
    PhoneImageAndColorService phoneImageAndColorService;
    @Autowired
    BuyerService buyerService;

    @GetMapping("/api/phone")
    public List<PhoneDTO> getPhoneDTO() {
        return phoneService.getPhoneDTO();
    }

    @GetMapping("/api/phone/paged")
    public Page<PhoneDTO> getPhoneDTOByPage(@PageableDefault(value = 9) Pageable pageable) {
        return phoneService.getPhoneDTOPage(pageable);
    }

    @PostMapping("/api/phone")
    public ResponseEntity<?> createPhone(
            @RequestBody NewPhoneDTO newPhone,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (newPhone == null) {
            return new ResponseEntity<>("", HttpStatus.FORBIDDEN);
        }
        String brand = newPhone.getBrand();
        String model = newPhone.getModel();
        //llegan vacios la ram y el rom xd
        List<String> RAM = newPhone.getRAM();
        List<String> ROM = newPhone.getROM();
        String cameraDescription = newPhone.getCameraDescription();
        String processor = newPhone.getProcessor();
        Double price = newPhone.getPrice();
        int stock = newPhone.getStock();
        String battery = newPhone.getBattery();
        String size = newPhone.getSize();
        List<String> linkImage = newPhone.getLinkImage();
        String phoneColor = newPhone.getPhoneColor();
        if (brand.isEmpty()) {
            return new ResponseEntity<>("brand is empty", HttpStatus.FORBIDDEN);
        }
        if (model.isEmpty()) {
            return new ResponseEntity<>("model is empty", HttpStatus.FORBIDDEN);
        }
        if (RAM.size() == 0) {
            return new ResponseEntity<>("RAM size is equal to 0", HttpStatus.FORBIDDEN);
        }
        if (ROM.size() == 0) {
            return new ResponseEntity<>("ROM size is equal to 0", HttpStatus.FORBIDDEN);
        }
        if (cameraDescription.isEmpty()) {
            return new ResponseEntity<>("cameraDescription is empty", HttpStatus.FORBIDDEN);
        }
        if (processor.isEmpty()) {
            return new ResponseEntity<>("processor is empty", HttpStatus.FORBIDDEN);
        }
        if (price == null || price <= 0) {
            return new ResponseEntity<>("price is equal to 0", HttpStatus.FORBIDDEN);
        }
        if (stock <= 0) {
            return new ResponseEntity<>("stock is equal to 0", HttpStatus.FORBIDDEN);
        }
        if (linkImage.size() == 0) {
            return new ResponseEntity<>("linkImage size is equal to 0", HttpStatus.FORBIDDEN);
        }
        if (phoneColor.isEmpty()) {
            return new ResponseEntity<>("phoneColor is empty", HttpStatus.FORBIDDEN);
        }
        if (battery.isEmpty()) {
            return new ResponseEntity<>("battery is empty", HttpStatus.FORBIDDEN);
        }
        if (size.isEmpty()) {
            return new ResponseEntity<>("size is empty", HttpStatus.FORBIDDEN);
        }
        List<Integer> ramNumber = RAM.stream().map(number -> Integer.parseInt(number)).collect(Collectors.toList());
        List<Integer> romNumber = ROM.stream().map(number -> Integer.parseInt(number)).collect(Collectors.toList());
        Phone phoneNew = new Phone(brand, model, ramNumber, romNumber, cameraDescription, processor, price, stock, battery, size);
        PhoneImageAndColor phoneImageAndColorNew = new PhoneImageAndColor(linkImage, phoneColor);
        phoneNew.addImagesAndColor(phoneImageAndColorNew);
        phoneService.savePhone(phoneNew);

//        phoneImageAndColorRepository.save(phoneImageAndColorNew);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/phone/delete")
    public ResponseEntity<?> deletePhone(
            @RequestParam long phoneId,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (phoneId <= 0) {
            return new ResponseEntity<>("phoneId  is equal to 0", HttpStatus.FORBIDDEN);
        }
        Phone phoneDelete = phoneService.findById(phoneId);
        if (phoneDelete == null) {
            return new ResponseEntity<>("phone with phoneId is null", HttpStatus.FORBIDDEN);
        }
        phoneDelete.setEnable(false);
        phoneService.savePhone(phoneDelete);


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/api/phone/stock")
    public ResponseEntity<?> setterStock(
            @RequestParam int stock,
            @RequestParam long phoneId,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (stock <= 0) {
            return new ResponseEntity<>("stock is equal to 0", HttpStatus.FORBIDDEN);
        }
        if (phoneId == 0) {
            return new ResponseEntity<>("accessory is equal to 0", HttpStatus.FORBIDDEN);
        }
        Phone foundPhone = phoneService.findById(phoneId);
        if (foundPhone == null) {
            return new ResponseEntity<>("accessory with accessoryId is null", HttpStatus.FORBIDDEN);
        }
        foundPhone.setStock(stock);
        phoneService.savePhone(foundPhone);


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/api/phone/price")
    public ResponseEntity<?> setterPrice(
            @RequestParam double price,
            @RequestParam long phoneId,
            Authentication authentication
    ) {
        Buyer buyerCurrent = buyerService.findByEmail(authentication.getName());
        if (buyerCurrent == null) {
            return new ResponseEntity<>("buyerCurrent is null", HttpStatus.FORBIDDEN);
        }
        if (price <= 0) {
            return new ResponseEntity<>("stock is equal to 0", HttpStatus.FORBIDDEN);
        }
        if (phoneId == 0) {
            return new ResponseEntity<>("accessory is equal to 0", HttpStatus.FORBIDDEN);
        }
        Phone foundPhone = phoneService.findById(phoneId);

        if (foundPhone == null) {
            return new ResponseEntity<>("accessory with accessoryId is null", HttpStatus.FORBIDDEN);
        }
        foundPhone.setPrice(price);
        phoneService.savePhone(foundPhone);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
