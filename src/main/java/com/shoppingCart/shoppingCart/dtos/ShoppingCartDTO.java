package com.shoppingCart.shoppingCart.dtos;

import com.shoppingCart.shoppingCart.models.Client;
import com.shoppingCart.shoppingCart.models.ShoppingCart;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class ShoppingCartDTO {

    public Double price;


    public ShoppingCartDTO(ShoppingCart shoppingCart) {
        this.price= shoppingCart.getPrice();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
