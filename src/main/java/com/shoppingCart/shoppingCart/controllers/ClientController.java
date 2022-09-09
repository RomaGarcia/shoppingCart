package com.shoppingCart.shoppingCart.controllers;

import com.shoppingCart.shoppingCart.dtos.ClientCreateDTO;
import com.shoppingCart.shoppingCart.dtos.ClientDTO;
import com.shoppingCart.shoppingCart.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ClientController {

    @Autowired
    public ClientService clientService;

    @GetMapping("/api/admin/clients")
    public Set<ClientDTO> getClients(){
        return clientService.getClients();
    }
    @GetMapping("/api/admin/clients/all")
    public Set<ClientDTO> getClientsAll(){
        return clientService.getClientsAll();
    }

    @PostMapping("/api/clients")
    public ResponseEntity<Object> register(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password, @RequestParam String address) {
        return clientService.register(firstName,lastName,email,password,address);
    }
    @PatchMapping("/api/clients/{id}")
    public void update(@PathVariable Long id, @RequestBody ClientCreateDTO clientCreateDTO){
        clientService.update(id, clientCreateDTO);
    }
    @PatchMapping("/api/admin/clients/setstatus/{id}")
    public void setStatus(@PathVariable Long id){
        System.out.println(id);
        clientService.setStatus(id);
    }
}
