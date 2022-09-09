package com.shoppingCart.shoppingCart.controllers;

import com.shoppingCart.shoppingCart.dtos.ProductLoadCreateDTO;
import com.shoppingCart.shoppingCart.services.ProductLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductLoadController {
    @Autowired
    public ProductLoadService productLoadService;

    @PostMapping("/shoppingcarts/productloads/add")
    public ResponseEntity<Object> add(@RequestParam Long productId, @RequestParam Integer amount, @RequestParam Long shoppingCartId){
        return productLoadService.add(productId, amount, shoppingCartId);
    }
    @PatchMapping("/shoppingCarts/productLoads/remove{id}")
    public ResponseEntity<Object> remove(@PathVariable Long id){
        productLoadService.remove(id);
        return new ResponseEntity<>("removed", HttpStatus.ACCEPTED);
    }
    @PatchMapping("/shoppingCarts/productLoads/setAmount")
    public ResponseEntity<Object> setAmount(@RequestParam Long id, @RequestParam Integer amount){
        productLoadService.setAmount(id, amount);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
