package com.shoppingCart.shoppingCart.controllers;

import com.shoppingCart.shoppingCart.dtos.ClientDTO;
import com.shoppingCart.shoppingCart.dtos.ProductDTO;
import com.shoppingCart.shoppingCart.services.CategoryService;
import com.shoppingCart.shoppingCart.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ClientController {

    @Autowired
    public ClientService clientService;

    @GetMapping("api/clients")
    public Set<ClientDTO> getClients(){
        return clientService.getClients();
    }
    @GetMapping("api/clients/all")
    public Set<ClientDTO> getClientsAll(){
        return clientService.getClientsAll();
    }

    @PostMapping("/clients")
    public ResponseEntity<Object> register(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password, @RequestParam String address) {
        return clientService.register(firstName,lastName,email,password,address);

    }
}
