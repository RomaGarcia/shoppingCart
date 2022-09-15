package com.shoppingCart.shoppingCart.controllers;

import com.shoppingCart.shoppingCart.dtos.CardValidationDTO;
import com.shoppingCart.shoppingCart.dtos.ShoppingCartDTO;
import com.shoppingCart.shoppingCart.models.ShoppingCart;
import com.shoppingCart.shoppingCart.services.ShoppingCartService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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


    @ApiOperation(value = "listar todos los carros. Requiere permiso de admin")
    @GetMapping("admin/shoppingCartList")
    public List<ShoppingCartDTO> getAllShoppingCart(){
        return shoppingCartService.getAllShoppingCart();
    }


    @ApiOperation(value = "devuelve el carro activo del cliente conectado")
    @GetMapping("/shoppingCart")
    public ShoppingCartDTO getShoppingCartByClient(Authentication authentication){
        return shoppingCartService.getShoppingCartByClient(authentication);
    }

    @ApiOperation(value = "realiza la operacion de compra")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "compra realizada"),
            @ApiResponse(code = 403, message = "error en la compra")
    })
    @Transactional
    @PostMapping("/shoppingCart/buy")
    public ResponseEntity<Object> buy(Authentication authentication, @RequestParam  @ApiParam(name = "wayToPay", value = "forma de pago", example = "CREDITO")String wayToPay, @RequestBody @ApiParam(name = "cardValidationDTO", value = "informacion de la tarjeta del cliente") CardValidationDTO cardValidationDTO){
        return shoppingCartService.buy(authentication, wayToPay, cardValidationDTO);
    }

}
