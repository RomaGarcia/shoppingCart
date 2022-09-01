package com.shoppingCart.shoppingCart.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name= "native", strategy = "native")
    public Long id;

    public Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Client client;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ticket_id")
    private ShoppingCart shoppingCart;


    public ShoppingCart() {
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

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "price=" + price +
                '}';
    }
}
