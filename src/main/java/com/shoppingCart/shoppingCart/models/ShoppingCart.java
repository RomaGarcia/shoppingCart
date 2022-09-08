package com.shoppingCart.shoppingCart.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name= "native", strategy = "native")
    private Long id;

    private Double price;

    private Boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Client client;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ticket_id")
    private Ticket ticket;

    @OneToMany(fetch = FetchType.EAGER)
   private Set<ProductLoad> productLoans = new HashSet<>();


    public ShoppingCart() {
    }

    public ShoppingCart(Client client) {
        this.client = client;
        this.status= true;
    }

    public ShoppingCart(Double price) {
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Set<ProductLoad> getProductLoans() {
        return productLoans;
    }

    public void setProductLoans(Set<ProductLoad> productLoans) {
        this.productLoans = productLoans;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void addProductLoad(ProductLoad productLoad){
        this.productLoans.add(productLoad);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "price=" + price +
                '}';
    }
}
