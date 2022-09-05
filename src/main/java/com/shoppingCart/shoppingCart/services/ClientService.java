package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.dtos.ClientDTO;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface ClientService {
    Set<ClientDTO> getClients();
    Set<ClientDTO> getClientsAll();
    ResponseEntity<Object> register(String firstName, String lastName, String email, String password, String address);
}
