package ChallengeFinal.service;

import ChallengeFinal.models.Buyer;
import ChallengeFinal.models.TicketPurchase;
import com.lowagie.text.DocumentException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface PdfService {
    public void export(Buyer buyer, TicketPurchase ticketPurchase, HttpServletResponse response) throws IOException, DocumentException;
}
