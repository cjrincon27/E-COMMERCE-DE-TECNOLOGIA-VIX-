package ChallengeFinal.dtos;

import ChallengeFinal.models.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartDTO {
    private long id;
    private long buyerId;
    private List<TicketAccessory_CartDTO> ticketAccessory_carts = new ArrayList<>();
    private List<TicketConsole_CartDTO> ticketConsole_carts = new ArrayList<>();
    private List<TicketPhone_CartDTO> ticketPhone_carts = new ArrayList<>();

    public ShoppingCartDTO() {
    }

    public ShoppingCartDTO(ShoppingCart shoppingCart) {
        this.id = shoppingCart.getId();
        this.buyerId = shoppingCart.getBuyer().getId();
        this.ticketAccessory_carts = shoppingCart.getTicketAccessory_carts().stream().map(ticketAccessory_cart -> new TicketAccessory_CartDTO(ticketAccessory_cart)).collect(Collectors.toList());
        this.ticketConsole_carts = shoppingCart.getTicketConsole_carts().stream().map(ticketConsole_cart -> new TicketConsole_CartDTO(ticketConsole_cart)).collect(Collectors.toList());
        this.ticketPhone_carts = shoppingCart.getTicketPhone_carts().stream().map(ticketPhone_cart -> new TicketPhone_CartDTO(ticketPhone_cart)).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public List<TicketAccessory_CartDTO> getTicketAccessory_carts() {
        return ticketAccessory_carts;
    }

    public List<TicketConsole_CartDTO> getTicketConsole_carts() {
        return ticketConsole_carts;
    }

    public List<TicketPhone_CartDTO> getTicketPhone_carts() {
        return ticketPhone_carts;
    }
}
