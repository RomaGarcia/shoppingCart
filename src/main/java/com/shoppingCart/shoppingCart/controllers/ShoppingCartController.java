package com.shoppingCart.shoppingCart.controllers;

import com.shoppingCart.shoppingCart.dtos.CardValidationDTO;
import com.shoppingCart.shoppingCart.dtos.ShoppingCartDTO;
import com.shoppingCart.shoppingCart.models.ShoppingCart;
import com.shoppingCart.shoppingCart.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("admin/shoppingCartList")
    public List<ShoppingCartDTO> getAllShoppingCart(){
        return shoppingCartService.getAllShoppingCart();
    }

    @GetMapping("/shoppingCart/{id}")
    public ShoppingCartDTO getShoppingCartById(@PathVariable Long id){
        return shoppingCartService.getShoppingCartById(id);
    }
    @Transactional
    @PostMapping("/shoppingCart/buy")
    public ResponseEntity<Object> buy(Authentication authentication, @RequestParam String wayToPay, @RequestBody CardValidationDTO cardValidationDTO){
        return shoppingCartService.buy(authentication, wayToPay, cardValidationDTO);
    }

}
