package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.models.ShoppingCart;

public interface TicketService {
    void create(ShoppingCart shoppingCart, String wayToPay);
}
