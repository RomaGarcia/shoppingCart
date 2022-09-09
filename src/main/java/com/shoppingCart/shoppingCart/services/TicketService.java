package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.models.ShoppingCart;
import com.shoppingCart.shoppingCart.models.Ticket;

public interface TicketService {
    Ticket create(ShoppingCart shoppingCart, String wayToPay);
}
