package com.shoppingCart.shoppingCart.controllers;

import com.shoppingCart.shoppingCart.dtos.ProductLoadCreateDTO;
import com.shoppingCart.shoppingCart.services.ProductLoadService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductLoadController {
    @Autowired
    public ProductLoadService productLoadService;


    @ApiOperation(value = "agregar un producto al carro")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "producto añadido")
    })
    @PostMapping("/shoppingcarts/productLoads/add")
    public ResponseEntity<Object> add(@RequestParam @ApiParam(name = "id", value = "id del producto a cargar", example = "1") Long productId, @RequestParam @ApiParam(name = "quantity", value = "cantidad de producto a cargar", example = "1") Integer quantity, Authentication authentication){
        return productLoadService.add(productId, quantity, authentication);
    }

    @ApiOperation(value = "quitar un producto del carro")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "removido")
    })
    @PatchMapping("/shoppingCarts/productLoads/remove{id}")
    public ResponseEntity<Object> remove(@PathVariable @ApiParam(name = "id", value = "id del producto cargado", example = "1") Long id){
        productLoadService.remove(id);
        return new ResponseEntity<>("removed", HttpStatus.ACCEPTED);
    }
    @PatchMapping("/shoppingCarts/productLoads/setQuantity")
    @ApiOperation(value = "Cambiar la cantidad de un producto en el carrito")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "")
    })
    public ResponseEntity<Object> setAmount(@RequestParam @ApiParam(name = "id", value = "id del producto cargado", example = "1")Long id, @RequestParam @ApiParam(name = "amount", value = "cantidad cargada del producto", example = "3") Integer amount){
        productLoadService.setAmount(id, amount);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
