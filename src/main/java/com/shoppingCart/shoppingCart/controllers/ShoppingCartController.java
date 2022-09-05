package com.shoppingCart.shoppingCart.controllers;

import com.shoppingCart.shoppingCart.dtos.ShoppingCartDTO;
import com.shoppingCart.shoppingCart.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @RequestMapping("/shoppingCart/{id}")
    public ShoppingCartDTO getShoppingCartById(@PathVariable Long id){
        return shoppingCartService.getShoppingCartById(id);
    }

    @PostMapping("/clients/current/shoppingCart")
    public ResponseEntity<Object> postShoppingCart(Authentication authentication){
        return null;
    }

}
