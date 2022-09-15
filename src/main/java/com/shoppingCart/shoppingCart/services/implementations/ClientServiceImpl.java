package com.shoppingCart.shoppingCart.services.implementations;

import com.shoppingCart.shoppingCart.dtos.ClientCreateDTO;
import com.shoppingCart.shoppingCart.dtos.ClientDTO;
import com.shoppingCart.shoppingCart.models.Client;
import com.shoppingCart.shoppingCart.models.ShoppingCart;
import com.shoppingCart.shoppingCart.repositories.ClientRepository;
import com.shoppingCart.shoppingCart.repositories.ShoppingCartRepository;
import com.shoppingCart.shoppingCart.services.ClientService;
import com.shoppingCart.shoppingCart.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private SendEmailService sendEmailService;

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


        ShoppingCart shoppingCart1 = new ShoppingCart(client);
        clientRepository.save(client);
        shoppingCartRepository.save(shoppingCart1);

        sendEmailService.sendValidationMail(client);
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }

    @Override
    public void setStatus(Long id) {
        Client client = clientRepository.findById(id).get();
        client.setStatus(!client.getStatus());
        clientRepository.save(client);
    }

    @Override
    public void update(Long id, ClientCreateDTO clientCreateDTO) {
        Client client= clientRepository.findById(id).get();
        if (clientCreateDTO.getFirstName()!=null){
            client.setFirstName(clientCreateDTO.getFirstName());
        }
        if (clientCreateDTO.getLastName()!=null){
            client.setLastName(clientCreateDTO.getLastName());
        }
        if (clientCreateDTO.getEmail()!=null){
            client.setEmail(clientCreateDTO.getEmail());
        }
        if (clientCreateDTO.getPassword()!=null){
            client.setPassword(passwordEncoder.encode(clientCreateDTO.getPassword()));
        }
        if (clientCreateDTO.getAddress()!=null){
            client.setAddress(clientCreateDTO.getAddress());
        }
        clientRepository.save(client);
    }
    @Override
    public void validation(Long id){
        Client client= clientRepository.findById(id).get();
        client.setStatus(true);
        clientRepository.save(client);
    }

    @Override
    public boolean validateStatus(Authentication authentication){
        Client client=clientRepository.findByEmail(authentication.getName());
        return client.getStatus();
    }
}
