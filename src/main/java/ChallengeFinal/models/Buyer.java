package ChallengeFinal.models;


import ChallengeFinal.models.TicketPurchase;
import ChallengeFinal.utils.Utils;
import jdk.jshell.execution.Util;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name ="native")
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private  int code;
    private boolean validator;
    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY)
    private List<TicketPurchase> ticketPurchases = new ArrayList<>();
    @OneToOne(mappedBy = "buyer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ShoppingCart shoppingCart;
    public Buyer() {
    }

    public Buyer(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.validator = false;
        this.code = Utils.getActivationCode();
        this.shoppingCart =  new ShoppingCart(this);
    }
    public Buyer(String firstName, String lastName, String email, String password,boolean validator,int code) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.validator = validator;
        this.code=code;
    }

    public long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TicketPurchase> getTicketPurchases() {
        return ticketPurchases;
    }

    public void setTicketPurchases(List<TicketPurchase> ticketPurchases) {
        this.ticketPurchases = ticketPurchases;
    }

    public boolean isValidator() {
        return validator;
    }

    public void setValidator(boolean validator) {
        this.validator = validator;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addTicketPurchase(TicketPurchase ticketPurchase){
        ticketPurchase.setBuyer(this);
        ticketPurchases.add(ticketPurchase);
    }
}