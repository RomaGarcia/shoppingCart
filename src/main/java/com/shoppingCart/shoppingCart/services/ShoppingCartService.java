package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.dtos.ShoppingCartDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ShoppingCartService {

    List<ShoppingCartDTO> getAllShoppingCart();
    ShoppingCartDTO getShoppingCartById(@PathVariable Long id);
    void postShoppingCart(Authentication authentication);
}
