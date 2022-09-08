package com.shoppingCart.shoppingCart.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy="native")
    public Long id;

    public LocalDate date;

    public String wayToPay;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="shoppingCart_id")
    private ShoppingCart shoppingCart;


    public Ticket() {
    }


    public Ticket(LocalDate date, String wayToPay, ShoppingCart shoppingCart) {
        this.date = date;
        this.wayToPay = wayToPay;
        this.shoppingCart=shoppingCart;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getWayToPay() {
        return wayToPay;
    }

    public void setWayToPay(String wayToPay) {
        this.wayToPay = wayToPay;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "date=" + date +
                ", wayToPay='" + wayToPay + '\'' +
                '}';
    }
}
