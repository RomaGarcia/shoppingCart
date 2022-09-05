package com.shoppingCart.shoppingCart.services.implementations;

import com.shoppingCart.shoppingCart.dtos.ClientDTO;
import com.shoppingCart.shoppingCart.models.Client;
import com.shoppingCart.shoppingCart.repositories.ClientRepository;
import com.shoppingCart.shoppingCart.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public ClientRepository clientRepository;
    @Override
    public Set<ClientDTO> getClients() {
        return clientRepository.findByStatus(true).stream().map(ClientDTO::new).collect((toSet()));
    }

    @Override
    public Set<ClientDTO> getClientsAll() {
        return clientRepository.findAll().stream().map(ClientDTO::new).collect((toSet()));
    }

    @Override
    public ResponseEntity<Object> register(String firstName, String lastName, String email, String password, String address) {
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || address.isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        if (clientRepository.findByEmail(email) !=  null) {
            return new ResponseEntity<>("Name already in use", HttpStatus.FORBIDDEN);
        }

        Client client = new Client(firstName, lastName, email, passwordEncoder.encode(password),address);
        clientRepository.save(client);

        //CREAR CARRITO VACION Y ASIGNARSELO ????

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
