package ChallengeFinal.dtos;

import ChallengeFinal.models.Buyer;
import ChallengeFinal.models.ShoppingCart;
import ChallengeFinal.models.TicketPurchase;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BuyerDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<TicketPurchaseDTO> ticketPurchases = new HashSet<>();
    private ShoppingCartDTO shoppingCart;


    public BuyerDTO() {
    }

    public BuyerDTO(Buyer buyer) {
        this.id = buyer.getId();
        this.firstName = buyer.getFirstName();
        this.lastName = buyer.getLastName();
        this.email = buyer.getEmail();
        this.ticketPurchases = buyer.getTicketPurchases().stream().map(ticketPurchase -> new TicketPurchaseDTO(ticketPurchase)).collect(Collectors.toSet());
        this.shoppingCart = new ShoppingCartDTO(buyer.getShoppingCart());
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Set<TicketPurchaseDTO> getTicketPurchases() {
        return ticketPurchases;
    }

    public ShoppingCartDTO getShoppingCart() {
        return shoppingCart;
    }
}
