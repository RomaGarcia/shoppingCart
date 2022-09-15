package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.dtos.ClientCreateDTO;
import com.shoppingCart.shoppingCart.dtos.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.Set;

public interface ClientService {
    Set<ClientDTO> getClients();
    Set<ClientDTO> getClientsAll();
    ResponseEntity<Object> register(String firstName, String lastName, String email, String password, String address);
    void setStatus(Long id);

    void update(Long id, ClientCreateDTO clientCreateDTO);

    void validation(Long id);

    boolean validateStatus(Authentication authentication);
}
