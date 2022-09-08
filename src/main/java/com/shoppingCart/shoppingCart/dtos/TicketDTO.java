package com.shoppingCart.shoppingCart.dtos;

import com.shoppingCart.shoppingCart.models.ShoppingCart;
import com.shoppingCart.shoppingCart.models.Ticket;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketDTO {

    public LocalDate date;

    public String wayToPay;

    private ShoppingCart shoppingCart;

    public TicketDTO(Ticket ticket) {
        this.date=ticket.getDate();
        this.wayToPay= ticket.getWayToPay();
        this.shoppingCart= ticket.getShoppingCart();
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
}
