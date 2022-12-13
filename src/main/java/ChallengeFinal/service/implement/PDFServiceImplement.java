package ChallengeFinal.service.implement;

import ChallengeFinal.models.*;
import ChallengeFinal.repository.BuyerRepository;
import ChallengeFinal.service.PdfService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PDFServiceImplement implements PdfService {
    @Autowired
    BuyerRepository buyerRepository;

    @Override
    public void export(Buyer buyer, TicketPurchase ticketPurchase, HttpServletResponse response) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());
        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTitle.setSize(18);

        Paragraph title = new Paragraph("Purchases", fontTitle);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        Font fontParagraph = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontParagraph.setSize(12);
        Paragraph subtitle = new Paragraph("Client: "+ buyer.getEmail(), fontParagraph);
        subtitle.setAlignment(Paragraph.ALIGN_CENTER);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        Paragraph purchaseDate = new Paragraph("Date: " + dateTimeFormatter.format(ticketPurchase.getPurchaseDate()), fontParagraph);
        Paragraph finalPrice = new Paragraph("Total: $ " +ticketPurchase.getPriceFinal(), fontParagraph);
        finalPrice.setAlignment(Paragraph.ALIGN_RIGHT);
        Paragraph space = new Paragraph("\n");

//        com.lowagie.text.Image image = null;
//        image = Image.getInstance();
//        image.scaleAbsolute(100,100);
//        image.setAbsolutePosition(100, 100);
        com.lowagie.text.Image image = null;
        image= Image.getInstance("C:/Users/Pollo/Desktop/ChallengeFinal/src/main/resources/static/web/assets/img/VixFavicon.png");
        image.scaleAbsolute(150,100);
        image.setAbsolutePosition(415,750);
        document.add(image);

        PdfPTable table = new PdfPTable(5);
        Stream.of("Brand","Product","Type","Stock","Price").forEach(table::addCell);
        List<Ticket_Accessory> ticket_accessories = ticketPurchase.getTicketAccesories();
        ticket_accessories.forEach(ticket_accessory -> {
            table.addCell(ticket_accessory.getAccessory().getBrand());
            table.addCell(ticket_accessory.getAccessory().getModel());
            table.addCell("Accessory");
            table.addCell(""+ticket_accessory.getStock());
            table.addCell("$ " + (ticket_accessory.getStock() * ticket_accessory.getAccessory().getPrice()));
        });

        List<Ticket_Phone> ticket_phones = ticketPurchase.getTicketPhones();
        ticket_phones.forEach(ticket_phone -> {
            table.addCell(ticket_phone.getPhone().getBrand());
            table.addCell(ticket_phone.getPhone().getModel());
            table.addCell("Phone");
            table.addCell(""+ticket_phone.getStock());
            table.addCell("$ " + (ticket_phone.getStock() * ticket_phone.getPhone().getPrice()));
        });

        List<Ticket_Console> ticket_consoles = ticketPurchase.getTicketConsoles();
        ticket_consoles.forEach(ticket_console -> {
            table.addCell(ticket_console.getConsole().getBrand());
            table.addCell(ticket_console.getConsole().getModel());
            table.addCell("Accessory");
            table.addCell(""+ticket_console.getStock());
            table.addCell("$ " + (ticket_console.getStock() * ticket_console.getConsole().getPrice()));
        });

//        document.add(image);
        document.add(title);
        document.add(space);
        document.add(subtitle);
        document.add(purchaseDate);
        document.add(space);
        document.add(space);
        document.add(table);
        document.add(space);
        document.add(finalPrice);
        document.close();
    }
}
