package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.dtos.CardValidationDTO;
import com.shoppingCart.shoppingCart.dtos.ShoppingCartDTO;
import com.shoppingCart.shoppingCart.models.ProductLoad;
import com.shoppingCart.shoppingCart.models.ShoppingCart;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ShoppingCartService {

    List<ShoppingCartDTO> getAllShoppingCart();


    ShoppingCartDTO getShoppingCartByClient(Authentication authentication);

    void postShoppingCart(Authentication authentication);

    void remove(ShoppingCart shoppingCart, ProductLoad productLoad);



    ResponseEntity<Object> buy(Authentication authentication, String wayToPay, CardValidationDTO cardValidationDTO);
}
