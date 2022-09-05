package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.dtos.ShoppingCartDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;

public interface ShoppingCartService {

    ShoppingCartDTO getShoppingCartById(@PathVariable Long id);
    ResponseEntity<Object> postShoppingCart(Authentication authentication);
}
