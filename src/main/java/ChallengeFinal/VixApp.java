package ChallengeFinal;

import ChallengeFinal.controller.TicketAccessory_CartController;
import ChallengeFinal.models.*;
import ChallengeFinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class VixApp {

    public static void main(String[] args) {
        SpringApplication.run(VixApp.class, args);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initData(AccessoryRepository accessoryRepository, BuyerRepository buyerRepository,
                                        PhoneRepository phoneRepository, TicketPurchaseRepository ticketPurchaseRepository,
                                        Ticket_PhoneRepository ticket_phoneRepository, PhoneImageAndColorRepository phoneImageAndColorRepository,
                                        Ticket_AccesoryRepository ticket_accesoryRepository,ConsoleRepository consoleRepository,AccessoryImageAndColorRepository accessoryImageAndColorRepository) {
        return args -> {

//       Creando telefenos
            Phone phone1 = new Phone("Samsung", "Galaxy S22 Ultra", new ArrayList<>(List.of(8, 10)), new ArrayList<>(List.of(64, 128)),
                    "Rear camera - Resolution (multiple) 50.0 MP + 10.0 MP + 12.0 MP",
                 "Octa-Core", 378.97, 5, "5000 mAh", "163.3 mm x 77.9 mm x 8.9 mm");

          /*   Phone phone2 = new Phone("Samsung", "Galaxy S22", new ArrayList<>(List.of(8, 10)), new ArrayList<>(List.of(64, 128)),
                    "Rear camera - Resolution (multiple) 50.0 MP + 10.0 MP + 12.0 MP",
                    "Octa-Core", 378.97, 17, "4000", "163.3 mm x 77.9 mm x 8.9 mm");

                    "Octa-Core", 739.00, 5, "5000 mAh", "163.3 mm x 77.9 mm x 8.9 mm"); */

            Phone phone2 = new Phone("Samsung", "Galaxy S22", new ArrayList<>(List.of(8, 10)), new ArrayList<>(List.of(64, 128)),
                    "Rear camera - Resolution (multiple) 50.0 MP + 10.0 MP + 12.0 MP",
                    "Octa-Core", 309.99, 17, "4000", "163.3 mm x 77.9 mm x 8.9 mm");

            Phone phone3 = new Phone("Xiaomi", "12T", new ArrayList<>(List.of(8, 10)), new ArrayList<>(List.of(64, 128)),
                    "Rear camera - 108 MP triple camera + 8 MP + 2 MP",
                    "Dimensity 8100-Ultra", 449.99, 11, "5000 mAh", "163,1 mm x 75,9 mm x 8,6 mm");

            Phone phone4 = new Phone("Motorola", "Moto G200", new ArrayList<>(List.of(8, 10)), new ArrayList<>(List.of(64, 128)),
                    "Rear camera - 108MP + 13MP (wide & macro) + 2MP (depth)",
                    "Snapdragon 888+", 329.99, 2, "5000 mAh", "161.19 x 73.87 x 8.49");

            Phone phone5 = new Phone("Samsung", "Galaxy Z Fold4", new ArrayList<>(List.of(8, 10)), new ArrayList<>(List.of(64, 128, 256)),
                    "Main Camera - Resolution (Multiple) 50.0 MP + 12.0 MP + 10.0 MP",
                    "Octa-Core", 893.99, 10, "4400 mAh", "155.1 x 130.1 x 6.3");

            Phone phone6 = new Phone("Apple", "Iphone 14 Pro", new ArrayList<>(List.of(8, 10)), new ArrayList<>(List.of(32, 64, 128)),
                    "Principal:48MP, f/1.78, 24mm, OIS",
                    "Apple A16 Bionic", 974.99, 8, "5000 mAh", "147,5 x 71,5 x 7,8 mm");

            Phone phone7 = new Phone("Xiaomi","Pocophone Poco M3 Pro", new ArrayList<>(List.of(4,6)),new ArrayList<>(List.of(64,128)),
                    "It has 3 rear cameras 48Mpx/2Mpx/2Mpx/2Mpx front camera 8Mpx",
                    "MediaTek Dimensity 700 Octa-Core de 2.2GHz",159.99,10, "5000mAh", "6.5 (161.81 mm x 75.34 mm x 8.92 mm)");

            Phone phone8 = new Phone("Xiaomi", "Redmi 10 Dual",new ArrayList<>(List.of(4)), new ArrayList<>(List.of(64)),
                    "Main rear camera: 50 Mpx Main front camera: 8 Mpx",
                    "MediaTek Helio G88", 126.99, 5, "5000 mAh", "6.5 (161.95 mm x 75.53 mm x 8.92 mm)");

            Phone phone9 = new Phone("Xiaomi", "Redmi Note 11",new ArrayList<>(List.of(4,6)), new ArrayList<>(List.of(64,128)),
                    "Main Camera 50MP Secondary Camera 13mpx",
                    "Snapdragon 680 8ta Core", 177.99, 7, "5000mAh", "6.43 (159.87 mm x 73.87 mm x 8.09 mm)");

            Phone phone10 = new Phone("Motorola", "G52", new ArrayList<>(List.of(4,6)), new ArrayList<>(List.of(128)),
                    "It has 3 rear cameras of 50Mpx/8Mpx/2Mpx/2Mpx Front camera of 16Mpx",
                    "Snapdragon 680 Octa-Core de 2.4GHz", 356.00, 20, "5000mAh.", " 6.6 (160.98 mm x 74.46 mm x 7.99 mm)");
            //**
            Phone phone11 = new Phone("Hyundai", "L622", new ArrayList<>(List.of(2)), new ArrayList<>(List.of(32)),
                    "Main camera 13MP, f/1.8, AF",
                    "MTK6761, 1.8GHz", 72.50, 10, "3950 mAh", "6.22 (158 x 76 x 8 mm)");

            Phone phone12 = new Phone("Realme", "9i", new ArrayList<>(List.of(4,6)), new ArrayList<>(List.of(64,128)),
                    "50 Megapixel triple camera with AI 16 Megapixel on-screen front camera",
                    "Snapdragon 680", 163.99, 5, "5000 mAh", "6.6 (160,6 mm x 73,9 mm x 7,9 mm)");

            Phone phone13 = new Phone("LG", "K61", new ArrayList<>(List.of(4)), new ArrayList<>(List.of(128)),
                    "Quadruple main camera 48 MP, f/1.8, 26mm (wide), 1/2.0″, 0.8µm, PDAF",
                    "2.3GHz Octa-core (MT6765)", 100.00, 3, "4000mAh", "6.5 (164.5 mm x 77.5 mm x 8.4 mm)");

            Phone phone14 = new Phone("Huawei", "Y9", new ArrayList<>(List.of(3)), new ArrayList<>(List.of(64)),
                    "Front camera: aperture 16 M + 2 M, f/2.0 + f/2.4 Rear camera: aperture 13 M + 2 M, f/1.8 + f/2.4",
                    "Hisilicon Kirin 710", 185.00, 5, "4000 mAh", "6.5 (162.4 mm x 77.1 mm x 8.05 mm)");

            Phone phone15 = new Phone("Nokia", "G21", new ArrayList<>(List.of(3, 4)), new ArrayList<>(List.of(64, 128)),
                    "Rear camera:50 MP Main 1/2.76\" CMOS, 0.64um, 5P lens, f/1.8 + 2 MP Macro + 2 MP Depth Front camera: 8 MP"
                    , "Unisoc T606", 145.00, 5, "5050 mAh", "6.5 (164.6 mm x 75.9 mm x 8.5 mm)");

            Phone phone16 = new Phone("Huawei", "P30 Pro", new ArrayList<>(List.of(8)), new ArrayList<>(List.of(256)),
                    "Rear camera: 40 MP (Wide-angle lens, f/1.6 aperture, OIS) + 20 MP (Ultra-wide-angle lens, f/2.2 aperture) + 8 MP (Telephoto lens, f/3.4 aperture, OIS) Front camera: 32 MP, f/2.0 aperture",
                    "Octa-core Kirin 980", 410.00, 5, "4200 mAh", "6.47 (158 mm x 73.4 mm x 8.41 mm)");

            Phone phone17 = new Phone("Vivo", "Y20s", new ArrayList<>(List.of(4)), new ArrayList<>(List.of(128)),
                    "Camera Front 8MP / Rear 13MP+2MP+2MP Aperture Front f/1.8 (8MP), Rear f/2.2 (13MP) + f/2.4 (2MP)+ f/2.4 (2MP)",
                    "SDM460", 134.00, 10, "5000 mAh", "6.51 (164.41 mm x 76.32 mm x 8.41 mm)");

            Phone phone18 = new Phone("Apple", "iPhone 12", new ArrayList<>(List.of(4, 6)), new ArrayList<>(List.of(64, 128, 256)),
                    "12 MP dual-camera system: ultra wide-angle and wide-angle Ultra wide-angle: ƒ/2.4 aperture and 120° angle of view Wide-angle: ƒ/1.6 aperture",
                    "Chip A14 Bionic", 780.00, 5, "2775 mAh", "6.1 (146,7 mm x 71,5 mm x 7,4 mm)");

            Phone phone19 = new Phone("Oppo", "Reno7", new ArrayList<>(List.of(6)), new ArrayList<>(List.of(128)),
                    "Rear Main: 64MP, f/1.7; FOV 79°; 6P lens; AF, open-loop motor used Microscopic: 2MP, f/3.3; FOV 65°; 3P+IR lens; FF MONO: 2MP, f/2.4; FOV 89°; 3P+IR lens, FF Front Front Camera: 32MP, f/2.4; FOV 85°; 5P lens", "Snapdragon 680",
                    370.00, 5, "4500 mAh", "6.43 (159.9 mm x 73.2 mm x 7.49 mm)");

            Phone phone20 = new Phone("Alcatel", "1V", new ArrayList<>(List.of(2)), new ArrayList<>(List.of(32, 64)),
                    "Resolution: 5MP Focus Lens: 3P Aperture: f / 2.2 Sensor size: 1/5 inch Pixel size: 1.12 µm Resolution: 13MP + 5MP Lens: 5P Aperture: f / 1.8 Sensor size: 1/3 inch",
                    "MT6762D Octa-Core 4 x A53", 99.99, 10, "4000 mAh", "6.22 (158.7 mm x 74.8 mm x 8.85 mm)");
//          Guardando telefonos

            phoneRepository.save(phone4);
            phoneRepository.save(phone5);
            phoneRepository.save(phone6);
            phoneRepository.save(phone7);
            phoneRepository.save(phone8);
            phoneRepository.save(phone9);
            phoneRepository.save(phone10);
            phoneRepository.save(phone11);
            phoneRepository.save(phone12);
            phoneRepository.save(phone13);
            phoneRepository.save(phone14);
            phoneRepository.save(phone15);
            phoneRepository.save(phone16);
            phoneRepository.save(phone17);
            phoneRepository.save(phone18);
            phoneRepository.save(phone19);
            phoneRepository.save(phone20);
            phoneRepository.save(phone1);
            phoneRepository.save(phone2);
            phoneRepository.save(phone3);

//          Creando fotos y colores para los telefonos
//          Samsung Galaxy s22 ultra
            PhoneImageAndColor phoneImageAndColor1 = new PhoneImageAndColor(new ArrayList<>(List.of("https://images.samsung.com/ar/smartphones/galaxy-s22/models/images/galaxy-s22-ultra_models_colors_burgundy.jpg")),"Red");
            PhoneImageAndColor phoneImageAndColor2 = new PhoneImageAndColor(new ArrayList<>(List.of("https://images.samsung.com/ar/smartphones/galaxy-s22/models/images/galaxy-s22-ultra_models_colors_green.jpg")),"Green");
            PhoneImageAndColor phoneImageAndColor3 = new PhoneImageAndColor(new ArrayList<>(List.of("https://images.samsung.com/ar/smartphones/galaxy-s22/models/images/galaxy-s22-ultra_models_colors_phantom-white.jpg")),"White");
            PhoneImageAndColor phoneImageAndColor4 = new PhoneImageAndColor(new ArrayList<>(List.of("https://images.samsung.com/ar/smartphones/galaxy-s22/models/images/galaxy-s22-ultra_models_colors_phantom-black.jpg")),"Black");
//          Samsung Galaxy s22 plus
            PhoneImageAndColor phoneImageAndColor5 = new PhoneImageAndColor(new ArrayList<>(List.of("https://images.samsung.com/ar/smartphones/galaxy-s22/models/images/galaxy-s22-plus_models_colors_phantom-white.jpg")),"White");
            PhoneImageAndColor phoneImageAndColor6 = new PhoneImageAndColor(new ArrayList<>(List.of("https://images.samsung.com/ar/smartphones/galaxy-s22/models/images/galaxy-s22-plus_models_colors_green.jpg")),"Green");
            PhoneImageAndColor phoneImageAndColor7 = new PhoneImageAndColor(new ArrayList<>(List.of("https://images.samsung.com/ar/smartphones/galaxy-s22/models/images/galaxy-s22-plus_models_colors_pink-gold.jpg")),"Pink");
            PhoneImageAndColor phoneImageAndColor8 = new PhoneImageAndColor(new ArrayList<>(List.of("https://images.samsung.com/ar/smartphones/galaxy-s22/models/images/galaxy-s22-plus_models_colors_phantom-black.jpg")),"Black");
//          Samsung z Fold 4
            PhoneImageAndColor phoneImageAndColor9 = new PhoneImageAndColor(new ArrayList<>(List.of("https://samsungar.vtexassets.com/arquivos/ids/183270-1200-auto?width=1200&height=auto&aspect=true")),"Black");
            PhoneImageAndColor phoneImageAndColor10 = new PhoneImageAndColor(new ArrayList<>(List.of("https://samsungar.vtexassets.com/arquivos/ids/183278-1200-auto?width=1200&height=auto&aspect=true")), "Gray");
            PhoneImageAndColor phoneImageAndColor11 = new PhoneImageAndColor(new ArrayList<>(List.of("https://samsungar.vtexassets.com/arquivos/ids/183287-1200-auto?width=1200&height=auto&aspect=true")),"Gold");
//          Xiomi 12t
            PhoneImageAndColor phoneImageAndColor12 = new PhoneImageAndColor(new ArrayList<>(List.of ("https://http2.mlstatic.com/D_NQ_NP_894296-MLA52522628380_112022-O.webp")),"Blue");
            PhoneImageAndColor phoneImageAndColor13 = new PhoneImageAndColor(new ArrayList<>(List.of ("https://http2.mlstatic.com/D_NQ_NP_687696-MLA52522578568_112022-O.webp")),"Black");
//          moto g200
            PhoneImageAndColor phoneImageAndColor14 = new PhoneImageAndColor(new ArrayList<>(List.of ("https://cdnlaol.laanonimaonline.com/web/images/fotos/b/0000044000/25890_1.jpg")),"Blue");
//          aple iphone 14 pro
            PhoneImageAndColor phoneImageAndColor15 = new PhoneImageAndColor(new ArrayList<>(List.of ("https://http2.mlstatic.com/D_NQ_NP_726811-MLM51559388195_092022-O.webp")),"Purple");
            PhoneImageAndColor phoneImageAndColor16 = new PhoneImageAndColor(new ArrayList<>(List.of ("https://http2.mlstatic.com/D_NQ_NP_913741-MLM51559386469_092022-O.webp")),"Black");
            PhoneImageAndColor phoneImageAndColor17 = new PhoneImageAndColor(new ArrayList<>(List.of ("https://http2.mlstatic.com/D_NQ_NP_750485-MLM51559388158_092022-O.webp")),"Gold");
            PhoneImageAndColor phoneImageAndColor18 = new PhoneImageAndColor(new ArrayList<>(List.of ("https://http2.mlstatic.com/D_NQ_NP_707630-MLM51559386375_092022-O.webp")),"White");
//          Xiaomi Poco M3 pro
            PhoneImageAndColor phoneImageAndColor19 = new PhoneImageAndColor(new ArrayList<>(List.of ("https://http2.mlstatic.com/D_NQ_NP_672553-MLA46924832493_072021-O.webp")),"Yellow");
            PhoneImageAndColor phoneImageAndColor20 = new PhoneImageAndColor(new ArrayList<>(List.of ("https://http2.mlstatic.com/D_NQ_NP_750792-MLA46924758811_072021-O.webp")),"Blue");
            PhoneImageAndColor phoneImageAndColor21 = new PhoneImageAndColor(new ArrayList<>(List.of ("https://http2.mlstatic.com/D_NQ_NP_605069-MLA46924758964_072021-O.webp")), "Black");
//          Xiaomi Redmi 10 Dual
            PhoneImageAndColor phoneImageAndColor22 = new PhoneImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_933400-MLA50111760560_052022-O.webp")),"White");
//          Xiaomi Redmi Note 11
            PhoneImageAndColor phoneImageAndColor23 = new PhoneImageAndColor(new ArrayList<>(List.of("https://cdnlaol.laanonimaonline.com/web/images/fotos/b/0000054000/31750_2.jpg")),"Black");
//          Motorola G52
            PhoneImageAndColor phoneImageAndColor24 = new PhoneImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_870186-MLA50817167819_072022-O.webp")),"Blue");
            PhoneImageAndColor phoneImageAndColor25 = new PhoneImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_954109-MLA50817264619_072022-O.webp")),"Black");
//          Hyundai L622
            PhoneImageAndColor phoneImageAndColor26 = new PhoneImageAndColor(new ArrayList<>(List.of("http://www.hyundaimobile.com/upload/product/203125066_iEanlPWd_20210717060453.jpg")),"Blue");
//          Realme 9i
            PhoneImageAndColor phoneImageAndColor27 = new PhoneImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_2X_840277-MLA52131744114_102022-F.webp")),"Black");
            PhoneImageAndColor phoneImageAndColor28 = new PhoneImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_2X_835684-MLA52140646025_102022-F.webp")), "Blue");
//          LG K61
            PhoneImageAndColor phoneImageAndColor29 = new PhoneImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_2X_990400-MCO52397277360_112022-F.webp")),"Gray");
//          Huawei Y9
            PhoneImageAndColor phoneImageAndColor30 = new PhoneImageAndColor(new ArrayList<>(List.of("https://www.alkosto.com/medias/6901443397204-001-750Wx750H?context=bWFzdGVyfGltYWdlc3wzNDcwODh8aW1hZ2UvanBlZ3xpbWFnZXMvaGNiL2gxMi85NjM3Mjc2ODExMjk0LmpwZ3xiYmUwMTUwZmZhZDk5NzMxOGY1MWEyZmJiNTcyMTdlOTQ5ZTFjMDBjZTllMmJiN2RlYTk3OTQ0NDdkNjc4Yjlj")),"Black");
            PhoneImageAndColor phoneImageAndColor31 = new PhoneImageAndColor(new ArrayList<>(List.of("https://www.ktronix.com/medias/6901443397228-001-750Wx750H?context=bWFzdGVyfGltYWdlc3w0MjU0ODh8aW1hZ2UvanBlZ3xpbWFnZXMvaGNhL2hiZS85NjM3Mjg2NDc3ODU0LmpwZ3w5NDhhNGRkMmU5M2QzOGVhYTczMGJkMzBlMjhjZDE2N2M4ZTA3M2ViY2YxNzhjYTNlYjg4MWMyNzc1OWU5Yjkw")),"Green");
            PhoneImageAndColor phoneImageAndColor32 = new PhoneImageAndColor(new ArrayList<>(List.of("https://www.alkosto.com/medias/6901443397211-001-750Wx750H?context=bWFzdGVyfGltYWdlc3w0NDMwMTZ8aW1hZ2UvanBlZ3xpbWFnZXMvaGI2L2hlYy85NjM3MjgxNjI4MTkwLmpwZ3w5OGMwZGIxOGUzMTc4YmFiMzRjOWFlNDA3NmY3YjVlZmYxMzgzZWY3NzE5ZjZjNzZjOTI1NzMyZTI5YTllMzkw")),"Blue");
//          Nokia G21
            PhoneImageAndColor phoneImageAndColor33 = new PhoneImageAndColor(new ArrayList<>(List.of("https://m.media-amazon.com/images/I/41C+btC4dwL._SL500_.jpg")),"Green");
//            PhoneImageAndColor phoneImageAndColor34 = new PhoneImageAndColor(new ArrayList<>(List.of("https://images.ctfassets.net/wcfotm6rrl7u/lO153I6ZlHxGcbUCoDffM/b5494685d953ca13f00015db658d78dc/nokia-G21-dusk-emotional-int.png?h=1200&fm=avif")),"Brown");
//          Huawei P30 Pro
            PhoneImageAndColor phoneImageAndColor35 = new PhoneImageAndColor(new ArrayList<>(List.of("https://m.media-amazon.com/images/I/61XM1qbUPUL.jpg")),"Blue");
            PhoneImageAndColor phoneImageAndColor36 = new PhoneImageAndColor(new ArrayList<>(List.of("https://m.media-amazon.com/images/I/51zDfRUUhHL.jpg")),"Black");
//          Vivo Y20s
            PhoneImageAndColor phoneImageAndColor37 = new PhoneImageAndColor(new ArrayList<>(List.of("https://www.alkosto.com/medias/6935117828220-001-750Wx750H?context=bWFzdGVyfGltYWdlc3wzMDc2MTN8aW1hZ2UvanBlZ3xpbWFnZXMvaDdlL2g5YS8xMjQzNDU5NzI0OTA1NC5qcGd8ODBlNzdkMTliZDhmZjM4MzA3OTk4N2ZhYjFmZTAxZTBhMzM2NDVkYmI5NmNkNjdiN2UwOTRlY2JlZDE3ZTBhMQ")),"Blue");
            PhoneImageAndColor phoneImageAndColor38 = new PhoneImageAndColor(new ArrayList<>(List.of("https://www.alkosto.com/medias/6935117828213-001-750Wx750H?context=bWFzdGVyfGltYWdlc3wyNjgzMzB8aW1hZ2UvanBlZ3xpbWFnZXMvaGM5L2hhMy8xMjQzNDU5MTM1MDgxNC5qcGd8NjYyYmFhYmU1MDIxMTU1NzQzYTJkZDY1NzcwYzYyMmE5OTU1OTMzNDVkNGQ4MDk2MDcxZmQ3ODg2ZGUzMTlmZQ")),"Black");
//          iPhone 12
            PhoneImageAndColor phoneImageAndColor39 = new PhoneImageAndColor(new ArrayList<>(List.of("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/refurb-iphone-12-white-2020?wid=1144&hei=1144&fmt=jpeg&qlt=90&.v=1635202752000")),"White");
            PhoneImageAndColor phoneImageAndColor40 = new PhoneImageAndColor(new ArrayList<>(List.of("https://obstore.co/wp-content/uploads/2021/07/pro12...jpg")),"Black");
            PhoneImageAndColor phoneImageAndColor41 = new PhoneImageAndColor(new ArrayList<>(List.of("https://www.tradeinn.com/f/13782/137821876/apple-iphone-12-128gb-6.1.jpg")),"Red");
//          Oppo Reno7
            PhoneImageAndColor phoneImageAndColor42 = new PhoneImageAndColor(new ArrayList<>(List.of("https://www.alkosto.com/medias/6932169307796-001-750Wx750H?context=bWFzdGVyfGltYWdlc3wyMzM0NDV8aW1hZ2UvanBlZ3xpbWFnZXMvaDBmL2g3Ni8xMjQxNzIxMjYxMjYzOC5qcGd8ZTE1MDUyMDY5OTBmMDhiMjg1OTJkYzUyYjI3YTA0Y2UwZTIzN2NlYWNkYTdmMzIyYjM5MzFlM2YwODZjMDZiOA")),"Blue");
            PhoneImageAndColor phoneImageAndColor43 = new PhoneImageAndColor(new ArrayList<>(List.of("https://www.alkosto.com/medias/6932169307789-001-750Wx750H?context=bWFzdGVyfGltYWdlc3wxOTgyNTV8aW1hZ2UvanBlZ3xpbWFnZXMvaDEwL2gyMC8xMjQxNzIxMDc3NzYzMC5qcGd8MWI5NzQyOGUxNDZmMTVmYmY2NTlmMjQ1ZWFhYmNkZDNlODFjYjVkYzIxMTFkNjM2MzViNmI0YjQ5MWY0YjA3Mw")),"Black");
//          Alcatel 1V
            PhoneImageAndColor phoneImageAndColor44 = new PhoneImageAndColor(new ArrayList<>(List.of("https://www.alkosto.com/medias/4894461934709-001-750Wx750H?context=bWFzdGVyfGltYWdlc3wyMTIxNzN8aW1hZ2UvanBlZ3xpbWFnZXMvaDM0L2gxYy8xMzI5OTE4MTE5MTE5OC5qcGd8ODExNTljOTQwNWFlM2E4ZWEwOTdmMWQ3YmVhZWYzYmU2YTM2MThkZWE5NWM3NjlhMmUwOTBhODAxMGY4MjA1Mw")),"Black");
//         Agregando fotos y colores a los telefonos
            //Samsung Galaxy s22 ultra
            phone1.addImagesAndColor(phoneImageAndColor1);
            phone1.addImagesAndColor(phoneImageAndColor2);
            phone1.addImagesAndColor(phoneImageAndColor3);
            phone1.addImagesAndColor(phoneImageAndColor4);
//            Samsung Galaxy s22 plus
            phone2.addImagesAndColor(phoneImageAndColor5);
            phone2.addImagesAndColor(phoneImageAndColor6);
            phone2.addImagesAndColor(phoneImageAndColor7);
            phone2.addImagesAndColor(phoneImageAndColor8);
//            Samsung z Fold 4
            phone5.addImagesAndColor(phoneImageAndColor9);
            phone5.addImagesAndColor(phoneImageAndColor10);
            phone5.addImagesAndColor(phoneImageAndColor11);
            //          Xiomi 12t
            phone3.addImagesAndColor(phoneImageAndColor12);
            phone3.addImagesAndColor(phoneImageAndColor13);
            //          moto g200
            phone4.addImagesAndColor(phoneImageAndColor14);
//            aple iphone 14 pro
            phone6.addImagesAndColor(phoneImageAndColor15);
            phone6.addImagesAndColor(phoneImageAndColor16);
            phone6.addImagesAndColor(phoneImageAndColor17);
            phone6.addImagesAndColor(phoneImageAndColor18);
//          Xiaomi Poco M3 pro
            phone7.addImagesAndColor(phoneImageAndColor19);
            phone7.addImagesAndColor(phoneImageAndColor20);
            phone7.addImagesAndColor(phoneImageAndColor21);
//          Xiaomi Redmi 10 Dual
            phone8.addImagesAndColor(phoneImageAndColor22);
//          Xiaomi Redmi Note 11
            phone9.addImagesAndColor(phoneImageAndColor23);
//          Motorola G52
            phone10.addImagesAndColor(phoneImageAndColor24);
            phone10.addImagesAndColor(phoneImageAndColor25);
//          Hyundai L622
            phone11.addImagesAndColor(phoneImageAndColor26);
//          Realme 9i
            phone12.addImagesAndColor(phoneImageAndColor27);
            phone12.addImagesAndColor(phoneImageAndColor28);
//          LG K61
            phone13.addImagesAndColor(phoneImageAndColor29);
//          Huawei Y9
            phone14.addImagesAndColor(phoneImageAndColor30);
            phone14.addImagesAndColor(phoneImageAndColor31);
            phone14.addImagesAndColor(phoneImageAndColor32);
//          Nokia G21
            phone15.addImagesAndColor(phoneImageAndColor33);
//            phone15.addImagesAndColor(phoneImageAndColor34);
//          Huawei P30 Pro
            phone16.addImagesAndColor(phoneImageAndColor35);
            phone16.addImagesAndColor(phoneImageAndColor36);
//          Vivo Y20s
            phone17.addImagesAndColor(phoneImageAndColor37);
            phone17.addImagesAndColor(phoneImageAndColor38);
//          iPhone 12
            phone18.addImagesAndColor(phoneImageAndColor39);
            phone18.addImagesAndColor(phoneImageAndColor40);
            phone18.addImagesAndColor(phoneImageAndColor41);
//          Oppo Reno7
            phone19.addImagesAndColor(phoneImageAndColor42);
            phone19.addImagesAndColor(phoneImageAndColor43);
//          Alcatel 1V
            phone20.addImagesAndColor(phoneImageAndColor44);
//          Guardando imagenes de telefonos
            phoneImageAndColorRepository.save(phoneImageAndColor1);
            phoneImageAndColorRepository.save(phoneImageAndColor2);
            phoneImageAndColorRepository.save(phoneImageAndColor3);
            phoneImageAndColorRepository.save(phoneImageAndColor4);
            phoneImageAndColorRepository.save(phoneImageAndColor5);
            phoneImageAndColorRepository.save(phoneImageAndColor6);
            phoneImageAndColorRepository.save(phoneImageAndColor7);
            phoneImageAndColorRepository.save(phoneImageAndColor8);
            phoneImageAndColorRepository.save(phoneImageAndColor9);
            phoneImageAndColorRepository.save(phoneImageAndColor10);
            phoneImageAndColorRepository.save(phoneImageAndColor11);
            phoneImageAndColorRepository.save(phoneImageAndColor12);
            phoneImageAndColorRepository.save(phoneImageAndColor13);
            phoneImageAndColorRepository.save(phoneImageAndColor14);
            phoneImageAndColorRepository.save(phoneImageAndColor15);
            phoneImageAndColorRepository.save(phoneImageAndColor16);
            phoneImageAndColorRepository.save(phoneImageAndColor17);
            phoneImageAndColorRepository.save(phoneImageAndColor18);
            phoneImageAndColorRepository.save(phoneImageAndColor19);
            phoneImageAndColorRepository.save(phoneImageAndColor20);
            phoneImageAndColorRepository.save(phoneImageAndColor21);
            phoneImageAndColorRepository.save(phoneImageAndColor22);
            phoneImageAndColorRepository.save(phoneImageAndColor23);
            phoneImageAndColorRepository.save(phoneImageAndColor24);
            phoneImageAndColorRepository.save(phoneImageAndColor25);
            phoneImageAndColorRepository.save(phoneImageAndColor26);
            phoneImageAndColorRepository.save(phoneImageAndColor27);
            phoneImageAndColorRepository.save(phoneImageAndColor28);
            phoneImageAndColorRepository.save(phoneImageAndColor29);
            phoneImageAndColorRepository.save(phoneImageAndColor30);
            phoneImageAndColorRepository.save(phoneImageAndColor31);
            phoneImageAndColorRepository.save(phoneImageAndColor32);
            phoneImageAndColorRepository.save(phoneImageAndColor33);
//            phoneImageAndColorRepository.save(phoneImageAndColor34);
            phoneImageAndColorRepository.save(phoneImageAndColor35);
            phoneImageAndColorRepository.save(phoneImageAndColor36);
            phoneImageAndColorRepository.save(phoneImageAndColor37);
            phoneImageAndColorRepository.save(phoneImageAndColor38);
            phoneImageAndColorRepository.save(phoneImageAndColor39);
            phoneImageAndColorRepository.save(phoneImageAndColor40);
            phoneImageAndColorRepository.save(phoneImageAndColor41);
            phoneImageAndColorRepository.save(phoneImageAndColor42);
            phoneImageAndColorRepository.save(phoneImageAndColor43);
            phoneImageAndColorRepository.save(phoneImageAndColor44);

//          Creando consolas
            Console nintendoSwitch = new Console("Nintendo","Switch", 299.00 , 10 , "4gb" , "32gb", "Includes 2 controllers" ,"It includes: 1 joy-con grip, 2 joy-con straps, 1 dock, 1 hdmi cable, 1 power adapter.","https://i.imgur.com/5VwEnBn.jpg");
            Console playStation5 = new Console("Sony", "PlayStation 5", 499.99 , 89 , "16GB" , "825GB", "Includes controller" ,"Comes with: 1 vertical stand, 1 ac power cable, 1 usb cable, 1 hdmi cable, 1 quick start guide, 1 safety guide.","https://pbs.twimg.com/media/EaNeNC-XsAAMZ3u.jpg:large");
            Console xBoxSeries = new Console("Microsoft" ,"Xbox Series S" , 499.99 , 27 , "10GB" , "512GB" , "Includes controller","Includes: 1 hdmi cable, 1 ac power cable.","https://www.todofondos.net/wp-content/uploads/5120x2880-Dark-Souls-Mejores-Juegos-Fantasy-PC-XBOX-ONE-4K-FONDO-DE-PANTALLA-scaled.jpg");
            Console playStation4 = new Console("Sony", "PlayStation 4 Slim", 299.99,6,"8GB","500GB","Includes controller", "Includes: 1 AC power cable, 1 USB cable, 1 HDMI cable, 1 monaural headset.","https://4kwallpapers.com/images/wallpapers/the-division-2-warlords-of-new-york-tom-clancy-s-2560x1440-4680.jpg");

//          Agregando imagenes a consolas
//          NintendoSwitch
//            nintendoSwitch.addImage("https://i.imgur.com/i3922KJ.png");
            nintendoSwitch.addImage("https://i.imgur.com/zNr4ZBN.png");
            nintendoSwitch.addImage("https://i.imgur.com/ZpPbOul.png");
//            playStation 5
    //            playStation5.addImage("https://i.imgur.com/9iJaivY.png");
            playStation5.addImage("https://i.imgur.com/0Afj1Pw.png");
            playStation5.addImage("https://i.imgur.com/gT69KPb.png");
//            xBoxSeries
//            xBoxSeries.addImage("https://i.imgur.com/c4pRidb.png");
            xBoxSeries.addImage("https://i.imgur.com/iC5VhNG.png");
            xBoxSeries.addImage("https://i.imgur.com/S87QRwH.png");

//            playStation4
//            playStation4.addImage("https://i.imgur.com/q9Ikh2A.png");
            playStation4.addImage("https://i.imgur.com/kovibjm.png");
            playStation4.addImage("https://i.imgur.com/hVclZOO.png");

//            Guardando Consolas
            consoleRepository.save(nintendoSwitch);
            consoleRepository.save(playStation5);
            consoleRepository.save(xBoxSeries);
            consoleRepository.save(playStation4);

//          Creando Compradores
            Buyer buyer1 = new Buyer("Pollo", "crackero", "pollo@admin.com", passwordEncoder.encode("pollo123"));
            Buyer buyer2 = new Buyer("Alfre", "cerrezuela", "alfre@gmail.com", passwordEncoder.encode("alfre123"));

//          Creando ticketspurchase
            TicketPurchase ticket1 = new TicketPurchase( LocalDateTime.now(), LocalDateTime.now().plusMonths(1));
            TicketPurchase ticket2 = new TicketPurchase( LocalDateTime.now(), LocalDateTime.now().plusMonths(1));
//          Cliente agrega el ticketpurchase
            buyer1.addTicketPurchase(ticket1);
            buyer2.addTicketPurchase(ticket2);
//          Guardamos cliente
            buyer1.setValidator(true);
            buyer2.setValidator(true);


            buyerRepository.save(buyer1);
            buyerRepository.save(buyer2);

//          Guardamos ticket
            ticketPurchaseRepository.save(ticket1);
            ticketPurchaseRepository.save(ticket2);
//          Creando ticket phone
            Ticket_Phone ticket_phone1 = new Ticket_Phone(phone1,1,"");
            Ticket_Phone ticket_phone2 = new Ticket_Phone(phone2,1,"");
            Ticket_Phone ticket_phone3 = new Ticket_Phone(phone3,1,"");
            Ticket_Phone ticket_phone4 = new Ticket_Phone(phone4,1,"");
          //ticket 1 agrega los ticketphone
            ticket1.addTicketPhone(ticket_phone1);
            ticket1.addTicketPhone(ticket_phone2);
            ticket1.addTicketPhone(ticket_phone3);
            ticket1.addTicketPhone(ticket_phone4);
          //Guardamos los ticket phone
            ticket_phoneRepository.save(ticket_phone1);
            ticket_phoneRepository.save(ticket_phone2);
            ticket_phoneRepository.save(ticket_phone3);
            ticket_phoneRepository.save(ticket_phone4);
//          Creando accesorios
            Accessory accessory1 = new Accessory("It has True Wireless technology.;The battery lasts 5 hours." +
                    ";With noise cancellation.;With wireless charging case.;With built-in microphone.",
                    AccesoryType.HEADPHONE,"Samsung","Galaxy Buds2",12,151.29);
//            Accessory accessory2 = new Accessory("It has True Wireless technology.;10 m wireless range." +
//                    ";The battery lasts 5 hours.;With noise cancellation.;With wireless charging case.;With built-in microphone." +
//                    ";Water resistant.;Use suitable for sport.",
//                    AccesoryType.HEADPHONE, "Samsung", "Galaxy Buds2",
//                    6, 302.59);
            Accessory accessory3 = new Accessory("It has True Wireless technology.;13 m wireless range." +
                    ";The battery lasts 33 hours.;With noise cancellation.;With built-in microphone.",
                    AccesoryType.HEADPHONE, "Samsung", "Akg Y500",
                    11, 193.66);
            Accessory accessory4 = new Accessory("Active Noise Cancellation.;Resistance to water and sweat." +
                    ";Over 24 hours of total audio with the MagSafe(3) charging case.;Use suitable for sport.",
                    AccesoryType.HEADPHONE, "Apple", "AirPods Pro", 8, 263.86);
            Accessory accessory5 = new Accessory("Active Noise Cancellation that blocks outside noise." +
                    ";Ambient Mode so you can hear everything that happens around you." +
                    ";20 hours of audio.;Ultra low power consumption when stored.",
                    AccesoryType.HEADPHONE, "Apple", "AirPods Max", 5, 509.99);
            Accessory accessory6 = new Accessory("Automatic activation and connection.;Easy setup on all your Apple devices." +
                    ";Charging case to enjoy more than 24 hours of battery life.",
                    AccesoryType.HEADPHONE, "Apple", "AirPods", 14, 178.73);


            Accessory accessory7 = new Accessory("The most shock resistant front glass.;IP6X certified dust resistance, designed for swimming." +
                    ";Measure your blood oxygen level with a powerful sensor." +
                    ";Receive high and low heart rate notifications",AccesoryType.SMARTWATCH,"Apple","Watch Series 7",15,1030.00);
            Accessory accessory8 = new Accessory("Temperature Sensor, which offers estimates of the last ovulations." +
                    ";Powerful sensor and app to see the level of oxygen in the blood;High and low heart rate and irregular " +
                    "heart rhythm notifications",
                    AccesoryType.SMARTWATCH,"Apple","Watch Series 8",6,1077.20);
            Accessory accessory9 = new Accessory("High and low heart rate notifications;Receive calls and respond to messages from your wrist;" +
                    "Sync your favorite music and podcasts;Designed for swimming;Measures workouts like running, walking, etc.",
                    AccesoryType.SMARTWATCH,"Apple","Watch Series 3",9,540.61);
            Accessory accessory10 = new Accessory("1.4\" AMOLED touch screen.Suitable for downloading applications." +
                    ";Plays audio and video.;Resists up to 50m underwater.;With integrated GPS.;40-hour battery life.",
                    AccesoryType.SMARTWATCH,"Samsung","Galaxy Watch4",17,375.47);
            Accessory accessory11 = new Accessory("44\" screen.;Message management.;Plays audio.;Waterproof.;40-hour battery life and fast charge." +
                    ";Bluetooth and Wi-Fi connectivity.;Mesh interchangeable for other colors, not included in the product.",
                    AccesoryType.SMARTWATCH,"Samsung","Galaxy Watch5",8,514.36);
            Accessory accessory12 = new Accessory("1.4\" SAMOLED touch screen.;Suitable for downloading applications.;Plays audio." +
                    ";Resists up to 50m underwater.;With integrated GPS.;80-hour battery life.;Bluetooth and Wi-Fi connectivity.",
                    AccesoryType.SMARTWATCH,"Samsung","Galaxy Watch5 Pro",20,934.33);
            Accessory accessory13 = new Accessory("1.4\" SAMOLED touch screen.;Suitable for downloading applications.;Plays audio." +
                    ";Resists up to 50m underwater.;With integrated GPS.;80-hour battery life.;Bluetooth and Wi-Fi connectivity.",
                    AccesoryType.SMARTWATCH,"Samsung","Galaxy Watch4 Classic",3,451.89);

            Accessory jostickPlay5 = new Accessory("Wireless joystick",
                    AccesoryType.ACC_CONSOLE, "Sony", "DualSense CFI-ZCT1 cosmic", 26,75.00);
            Accessory jostickswitch = new Accessory("Joystick Games Wireless Accessory",
                    AccesoryType.ACC_CONSOLE, "Nintendo", "Switch", 5, 31.99);
            Accessory jostickXbox = new Accessory("Joystick Xbox",
                    AccesoryType.ACC_CONSOLE, "Microsoft", "Elite Series 2", 10, 39.99);
            Accessory jostickPlay4 = new Accessory("Wireless joystick",
                    AccesoryType.ACC_CONSOLE, "Sony", "Dualshock 4 urban", 8, 58.99);

            Accessory phonecase1 = new Accessory("Smart Case Samsung Galaxy S22 Ultra",
                    AccesoryType.PHONECASE, "Samsung", "Smart Clear View Cover", 10, 40.99);

            Accessory phonecase2 = new Accessory("Xiaomi 12T Pro Shockproof Silicone Cover",
                    AccesoryType.PHONECASE, "Xiaomi", "Silicone Cover", 10, 4.99);

            Accessory phonecase3 = new Accessory("Cover with Pen Stand for Galaxy Z Fold4",
                    AccesoryType.PHONECASE, "Samsung", "Cover with Pen Stand", 10, 46.76);

            Accessory phonecase4 = new Accessory("iPhone 14 Pro Clear Case with MagSafe",
                    AccesoryType.PHONECASE, "Apple", "Cover with MagSafe", 5, 49.00);

            Accessory phonecase5 = new Accessory("Liquid Silicone Case for Motorola Moto G52 4G",
                    AccesoryType.PHONECASE, "Motorola", "Cover for Moto G52", 10, 4.99);

            Accessory charger1 = new Accessory("Wall charger 25W type C",
                    AccesoryType.CHARGER, "Samsung", "charger 25W type C", 10, 19.99);

            Accessory charger2 = new Accessory("Wireless Charger for Samsung",
                    AccesoryType.CHARGER, "Samsung", "Wireless Charger", 10, 29.99);

            Accessory charger3 = new Accessory("20 W USB-C power adapter for iPhone",
                    AccesoryType.CHARGER, "Apple", "20 W USB-C power adapter", 10, 24.99);

            Accessory charger4 = new Accessory("Wireless Charger for iPhone",
                    AccesoryType.CHARGER, "Apple", "Wireless Charger", 10, 49.99);

            Accessory charger5 = new Accessory("Xiaomi 65W Wall Charger",
                    AccesoryType.CHARGER, "Xiaomi", "65W Wall Charger", 10, 15.99);
//            Agregando imagenes a los accesorios


//          Guardando accesorios
            accessoryRepository.save(accessory1);
//            accessoryRepository.save(accessory2);
            accessoryRepository.save(accessory3);
            accessoryRepository.save(accessory4);
            accessoryRepository.save(accessory5);
            accessoryRepository.save(accessory6);
            accessoryRepository.save(accessory7);
            accessoryRepository.save(accessory8);
            accessoryRepository.save(accessory9);
            accessoryRepository.save(accessory10);
            accessoryRepository.save(accessory11);
            accessoryRepository.save(accessory12);
            accessoryRepository.save(accessory13);
            accessoryRepository.save(jostickPlay5);
            accessoryRepository.save(jostickPlay4);
            accessoryRepository.save(jostickXbox);
            accessoryRepository.save(jostickswitch);
            accessoryRepository.save(phonecase1);
            accessoryRepository.save(phonecase2);
            accessoryRepository.save(phonecase3);
            accessoryRepository.save(phonecase4);
            accessoryRepository.save(phonecase5);
            accessoryRepository.save(charger1);
            accessoryRepository.save(charger2);
            accessoryRepository.save(charger3);
            accessoryRepository.save(charger4);
            accessoryRepository.save(charger5);

//           Galaxy Buds2
            AccessoryImageAndColor galaxyBugsBack = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_979658-MLA51774167128_092022-O.webp","https://http2.mlstatic.com/D_NQ_NP_839938-MLA51560279753_092022-O.webp","https://http2.mlstatic.com/D_NQ_NP_908212-MLA51774097712_092022-O.webp")),"Black");
            AccessoryImageAndColor galaxyBugsPurple = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_951241-MLA51774167661_092022-O.webp","https://http2.mlstatic.com/D_NQ_NP_678913-MLA51774185500_092022-O.webp","https://http2.mlstatic.com/D_NQ_NP_933204-MLA51774185490_092022-O.webp")),"Purple");
            accessory1.addImagesAndColor(galaxyBugsBack);
            accessory1.addImagesAndColor(galaxyBugsPurple);
//          Akg Y500
            AccessoryImageAndColor akg500  = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_845105-MLA50297137458_062022-O.webp","https://http2.mlstatic.com/D_NQ_NP_949933-MLA50297137461_062022-O.webp","https://http2.mlstatic.com/D_NQ_NP_985015-MLA50297109656_062022-O.webp")),"Black");
            accessory3.addImagesAndColor(akg500);
//          AirPods Pro
            AccessoryImageAndColor aripodsPro  = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_628246-MLA51654896964_092022-O.webp","https://http2.mlstatic.com/D_NQ_NP_990053-MLA51654931351_092022-O.webp","https://http2.mlstatic.com/D_NQ_NP_601998-MLA51654898958_092022-O.webp")),"White");
            accessory4.addImagesAndColor(aripodsPro);
//            AirPods MAx
            AccessoryImageAndColor airPodsMaxWhite = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_763092-MLA45715455112_042021-O.webp","https://http2.mlstatic.com/D_NQ_NP_988252-MLA45715466108_042021-O.webp")),"White");
            AccessoryImageAndColor airPodsMaxBlue = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_721876-MLA45714849823_042021-O.webp","https://http2.mlstatic.com/D_NQ_NP_670312-MLA45715010526_042021-O.webp")),"Blue");
            AccessoryImageAndColor airPodsMaxRed = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_801171-MLA45715455032_042021-O.webp","https://http2.mlstatic.com/D_NQ_NP_698621-MLA45715455036_042021-O.webp")),"Red");
            accessory5.addImagesAndColor(airPodsMaxWhite);
            accessory5.addImagesAndColor(airPodsMaxBlue);
            accessory5.addImagesAndColor(airPodsMaxRed);
//           airpods
            AccessoryImageAndColor airpods = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_631240-MLA48697556561_122021-O.webp","https://http2.mlstatic.com/D_NQ_NP_735081-MLA48697557580_122021-O.webp","https://http2.mlstatic.com/D_NQ_NP_756335-MLA48697557581_122021-O.webp")),"White");
            accessory6.addImagesAndColor(airpods);
//            Watch Series 7
            AccessoryImageAndColor watchSeries7Pink = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_907278-MLA49911054381_052022-O.webp")),"Pink");
            AccessoryImageAndColor watchSeries7White = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_644256-MLA52365117921_112022-O.webp")),"White");
            AccessoryImageAndColor watchSeries7Black = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_929321-MLA51181634988_082022-O.webp")),"Black");
            accessory7.addImagesAndColor(watchSeries7White);
            accessory7.addImagesAndColor(watchSeries7Pink);
            accessory7.addImagesAndColor(watchSeries7Black);
//          Watch Series 8
            AccessoryImageAndColor watchSeries8Black = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_710273-MLA52127704169_102022-O.webp","https://http2.mlstatic.com/D_NQ_NP_678083-MLA52127704170_102022-O.webp")),"Black");
            AccessoryImageAndColor watchSeries8Red = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_924759-MLA52127628971_102022-O.webp","https://http2.mlstatic.com/D_NQ_NP_896797-MLA52127704505_102022-O.webp")),"Red");
            AccessoryImageAndColor watchSeries8White = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_810401-MLA52127675157_102022-O.webp","https://http2.mlstatic.com/D_NQ_NP_972874-MLA52127628436_102022-O.webp")),"White");
            accessory8.addImagesAndColor(watchSeries8Black);
            accessory8.addImagesAndColor(watchSeries8Red);
            accessory8.addImagesAndColor(watchSeries8White);
//          Watch Series 3
            AccessoryImageAndColor watchSeries3Black =  new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_921615-MLA46398490002_062021-O.webp","https://http2.mlstatic.com/D_NQ_NP_766248-MLA46398490003_062021-O.webp")),"Black");
            AccessoryImageAndColor watchSeries3White =  new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_950903-MLA46398194431_062021-O.webp","https://http2.mlstatic.com/D_NQ_NP_686142-MLA46397868911_062021-O.webp")),"White");
            accessory9.addImagesAndColor(watchSeries3Black);
            accessory9.addImagesAndColor(watchSeries3White);
//            Galaxy Watch4
            AccessoryImageAndColor galaxyWatch4White =  new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_856639-MLA48026806283_102021-O.webp","https://http2.mlstatic.com/D_NQ_NP_955182-MLA48026762454_102021-O.webp")),"White");
            AccessoryImageAndColor galaxyWatch4Green =  new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_970200-MLA48026581729_102021-O.webp","https://http2.mlstatic.com/D_NQ_NP_888122-MLA48026721287_102021-O.webp")),"Green");
            accessory10.addImagesAndColor(galaxyWatch4White);
            accessory10.addImagesAndColor(galaxyWatch4Green);
//           Galaxy Watch5
            AccessoryImageAndColor galaxyWatch5White =  new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_666448-MLA51575430749_092022-O.webp","https://http2.mlstatic.com/D_NQ_NP_636413-MLA51575488427_092022-O.webp")),"White");
            AccessoryImageAndColor galaxyWatch5Black =  new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_796597-MLA51575488481_092022-O.webp","https://http2.mlstatic.com/D_NQ_NP_903946-MLA51575349961_092022-O.webp")),"Black");
            accessory11.addImagesAndColor(galaxyWatch5White);
            accessory11.addImagesAndColor(galaxyWatch5Black);
//          Galaxy Watch5 Pro
            AccessoryImageAndColor galaxyWatch5Pro = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_861532-MLA51439857424_092022-O.webp","https://http2.mlstatic.com/D_NQ_NP_936069-MLA51439791973_092022-O.webp")),"Black");
            accessory12.addImagesAndColor(galaxyWatch5Pro);
//          Galaxy Watch4 Classic
            AccessoryImageAndColor  galaxyWatch4Classic = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_708425-MLA47030150220_082021-O.webp","https://http2.mlstatic.com/D_NQ_NP_619927-MLA47029998656_082021-O.webp")),"Black");
            accessory13.addImagesAndColor(galaxyWatch4Classic);
//          Case Galaxy S22 Ultra
            AccessoryImageAndColor caseGalaxyS22Ultra = new AccessoryImageAndColor(new ArrayList<>(List.of("https://images.samsung.com/co/smartphones/galaxy-s22-ultra/accessories/images/cases/galaxy-s22-ultra_accessories_smart-clear-view-cover_black.jpg")),"Black");

            AccessoryImageAndColor caseXiaomi12T = new AccessoryImageAndColor(new ArrayList<>(List.of("https://cf.shopee.com.co/file/8bec357132753845928df76947d3a318_tn")),"Red");

            AccessoryImageAndColor caseGalaxyZFold4 = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_947245-MLA51424624010_092022-O.webp")), "Grey");

            AccessoryImageAndColor caseIphone14 = new AccessoryImageAndColor(new ArrayList<>(List.of("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MPU63?wid=2000&hei=2000&fmt=jpeg&qlt=95&.v=1661471392701")),"Purple");

            AccessoryImageAndColor caseMotoG52 = new AccessoryImageAndColor(new ArrayList<>(List.of("https://cdn.shopify.com/s/files/1/0622/6709/7324/products/C080597_M_1_2x_ef3e184f-1e9a-4fea-9235-42413f33a345_720x.jpg?v=1652790134")),"Black");


            AccessoryImageAndColor chargerSamsung = new AccessoryImageAndColor(new ArrayList<>(List.of("https://m.media-amazon.com/images/I/71vnY4p7QyL.jpg")),"Black");
            AccessoryImageAndColor chargerWirelessSamsung = new AccessoryImageAndColor(new ArrayList<>(List.of("https://images.samsung.com/is/image/samsung/co-wireless-charger-pad-pg920-galaxy-s6-ep-pg920ibegww-000000001-front-black?$PD_GALLERY_L_JPG$")),"Black");
            AccessoryImageAndColor chargerIphone = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_635369-MCO45224347286_032021-V.jpg")),"White");
            AccessoryImageAndColor chargerWirelessIphone = new AccessoryImageAndColor(new ArrayList<>(List.of("https://rukminim1.flixcart.com/image/416/416/kjym9ow0/charging-pad/i/l/z/2in1-mag-safe-wireless-charger-with-20-w-dock-for-iphone-original-imafzeqkzmzhumvg.jpeg?q=70")),"White");
            AccessoryImageAndColor chargerXiaomi = new AccessoryImageAndColor(new ArrayList<>(List.of("https://ae01.alicdn.com/kf/H53ab26eca38a4e30abfb3f7fb09ac684E/Original-Xiaomi-charger-65W-fast-charging-version-power-adapter-PD2-0-PD3-0-PPS-QC-4.jpg_Q90.jpg_.webp")),"White");
            phonecase1.addImagesAndColor(caseGalaxyS22Ultra);
            phonecase2.addImagesAndColor(caseXiaomi12T);
            phonecase3.addImagesAndColor(caseGalaxyZFold4);
            phonecase4.addImagesAndColor(caseIphone14);
            phonecase5.addImagesAndColor(caseMotoG52);

            charger1.addImagesAndColor(chargerSamsung);
            charger2.addImagesAndColor(chargerWirelessSamsung);
            charger3.addImagesAndColor(chargerIphone);
            charger4.addImagesAndColor(chargerWirelessIphone);
            charger5.addImagesAndColor(chargerXiaomi);



//            Guardamos la imagen
            accessoryImageAndColorRepository.save(galaxyBugsBack);
            accessoryImageAndColorRepository.save(galaxyBugsPurple);
            accessoryImageAndColorRepository.save(akg500);
            accessoryImageAndColorRepository.save(aripodsPro);
            accessoryImageAndColorRepository.save(airPodsMaxWhite);
            accessoryImageAndColorRepository.save(airPodsMaxBlue);
            accessoryImageAndColorRepository.save(airPodsMaxRed);
            accessoryImageAndColorRepository.save(airpods);
            accessoryImageAndColorRepository.save(watchSeries7Pink);
            accessoryImageAndColorRepository.save(watchSeries7White);
            accessoryImageAndColorRepository.save(watchSeries7Black);
            accessoryImageAndColorRepository.save(watchSeries8Black);
            accessoryImageAndColorRepository.save(watchSeries8Red);
            accessoryImageAndColorRepository.save(watchSeries8White);
            accessoryImageAndColorRepository.save(watchSeries3Black);
            accessoryImageAndColorRepository.save(watchSeries3White);
            accessoryImageAndColorRepository.save(galaxyWatch4White);
            accessoryImageAndColorRepository.save(galaxyWatch4Green);
            accessoryImageAndColorRepository.save(galaxyWatch5White);
            accessoryImageAndColorRepository.save(galaxyWatch5Black);
            accessoryImageAndColorRepository.save(galaxyWatch5Pro);
            accessoryImageAndColorRepository.save(galaxyWatch4Classic);
            accessoryImageAndColorRepository.save(caseGalaxyS22Ultra);
            accessoryImageAndColorRepository.save(caseXiaomi12T);
            accessoryImageAndColorRepository.save(caseGalaxyZFold4);
            accessoryImageAndColorRepository.save(caseIphone14);
            accessoryImageAndColorRepository.save(caseMotoG52);
            accessoryImageAndColorRepository.save(chargerSamsung);
            accessoryImageAndColorRepository.save(chargerWirelessSamsung);
            accessoryImageAndColorRepository.save(chargerIphone);
            accessoryImageAndColorRepository.save(chargerWirelessIphone);
            accessoryImageAndColorRepository.save(chargerXiaomi);



//            Jostickplay4
            AccessoryImageAndColor accjostickPlay5Urban =new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_673421-MLA52349227659_112022-O.webp")),"Urban");
            AccessoryImageAndColor accjostickPlay5Red =new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_Q_NP_810597-MLA52349227605_112022-R.webp","https://http2.mlstatic.com/D_NQ_NP_959588-MLA52349227609_112022-O.webp","https://http2.mlstatic.com/D_NQ_NP_642341-MLA52349180885_112022-O.webp","https://http2.mlstatic.com/D_NQ_NP_636009-MLA52349180887_112022-O.webp")),"Red");
            AccessoryImageAndColor accjostickPlay5Blue =new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_864316-MLA52349180913_112022-O.webp","https://http2.mlstatic.com/D_NQ_NP_864576-MLA52349237497_112022-O.webp")),"Blue berry");
            jostickPlay4.addImagesAndColor(accjostickPlay5Urban);
            jostickPlay4.addImagesAndColor(accjostickPlay5Red);
            jostickPlay4.addImagesAndColor(accjostickPlay5Blue);
//            jostick switch
            AccessoryImageAndColor accJostickSwitch = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_921576-MLA49948673515_052022-O.webp")),"black");
            jostickswitch.addImagesAndColor(accJostickSwitch);
//            jostick Xbox
            AccessoryImageAndColor accJostickXbox= new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_903321-MLA51696481403_092022-O.webp","https://http2.mlstatic.com/D_NQ_NP_825590-MLA51696724981_092022-O.webp","https://http2.mlstatic.com/D_NQ_NP_768940-MLA51696743563_092022-O.webp")),"White");
            jostickXbox.addImagesAndColor(accJostickXbox);
//            jostick Play5
            AccessoryImageAndColor accJostickPlay5Red = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_665357-MLA46237938567_062021-O.webp","https://http2.mlstatic.com/D_NQ_NP_965579-MLA46237942573_062021-O.webp","https://http2.mlstatic.com/D_NQ_NP_941166-MLA46237882975_062021-O.webp")),"Red");
            AccessoryImageAndColor accJostickPlay5Purple = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_928381-MLA49023008644_022022-O.webp","https://http2.mlstatic.com/D_NQ_NP_718138-MLA49023034066_022022-O.webp","https://http2.mlstatic.com/D_NQ_NP_739633-MLA51427111485_092022-O.webp")),"Purple");
            AccessoryImageAndColor accJostickPlay5Black = new AccessoryImageAndColor(new ArrayList<>(List.of("https://http2.mlstatic.com/D_NQ_NP_621951-MLA46237882917_062021-O.webp","https://http2.mlstatic.com/D_NQ_NP_904661-MLA46237938524_062021-O.webp","https://http2.mlstatic.com/D_NQ_NP_879189-MLA46237942521_062021-O.webp")),"Black");
            jostickPlay5.addImagesAndColor(accJostickPlay5Red);
            jostickPlay5.addImagesAndColor(accJostickPlay5Purple);
            jostickPlay5.addImagesAndColor(accJostickPlay5Black);

            accessoryImageAndColorRepository.save(accjostickPlay5Urban);
            accessoryImageAndColorRepository.save(accjostickPlay5Red);
            accessoryImageAndColorRepository.save(accjostickPlay5Blue);
            accessoryImageAndColorRepository.save(accJostickSwitch);
            accessoryImageAndColorRepository.save(accJostickXbox);
            accessoryImageAndColorRepository.save(accJostickPlay5Red);
            accessoryImageAndColorRepository.save(accJostickPlay5Purple);
            accessoryImageAndColorRepository.save(accJostickPlay5Black);

//          Creando ticket accessorios
            Ticket_Accessory ticket_accessory1 = new Ticket_Accessory(accessory1,1,"");
            Ticket_Accessory ticket_accessory2 = new Ticket_Accessory(accessory1,1,"");
            Ticket_Accessory ticket_accessory3 = new Ticket_Accessory(accessory1,1,"");
            Ticket_Accessory ticket_accessory4 = new Ticket_Accessory(accessory1,1,"");
            Ticket_Accessory ticket_accessory5 = new Ticket_Accessory(accessory1,1,"");
            Ticket_Accessory ticket_accessory6 = new Ticket_Accessory(accessory1,1,"");
            Ticket_Accessory ticket_accessory7 = new Ticket_Accessory(accessory1,1,"");
            //          Creando ticketspurchase
            TicketPurchase ticket3 = new TicketPurchase( LocalDateTime.now(), LocalDateTime.now().plusMonths(1));
            TicketPurchase ticket4 = new TicketPurchase( LocalDateTime.now(), LocalDateTime.now().plusMonths(1));
//           cliente guarda ticketpurchase
            buyer1.addTicketPurchase(ticket3);
            buyer2.addTicketPurchase(ticket4);

//            guardamos clientes
            buyerRepository.save(buyer1);
            buyerRepository.save(buyer2);

//           Agregando tickes accesorios a ticketpurchase
            ticket3.addTicketAccessory(ticket_accessory1);
            ticket3.addTicketAccessory(ticket_accessory2);
            ticket3.addTicketAccessory(ticket_accessory3);
            ticket3.addTicketAccessory(ticket_accessory4);
            ticket4.addTicketAccessory(ticket_accessory5);
            ticket4.addTicketAccessory(ticket_accessory6);
            ticket4.addTicketAccessory(ticket_accessory7);

            ticketPurchaseRepository.save(ticket3);
            ticketPurchaseRepository.save(ticket4);

            ticket_accesoryRepository.save(ticket_accessory1);
            ticket_accesoryRepository.save(ticket_accessory2);
            ticket_accesoryRepository.save(ticket_accessory3);
            ticket_accesoryRepository.save(ticket_accessory4);
            ticket_accesoryRepository.save(ticket_accessory5);
            ticket_accesoryRepository.save(ticket_accessory6);
            ticket_accesoryRepository.save(ticket_accessory7);

        };
    }

}
