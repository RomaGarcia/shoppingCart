package com.shoppingCart.shoppingCart.services.implementations;

import com.shoppingCart.shoppingCart.dtos.ShoppingCartDTO;
import com.shoppingCart.shoppingCart.models.Client;
import com.shoppingCart.shoppingCart.models.ShoppingCart;
import com.shoppingCart.shoppingCart.repositories.ClientRepository;
import com.shoppingCart.shoppingCart.repositories.ShoppingCartRepository;
import com.shoppingCart.shoppingCart.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

  @Autowired
  ShoppingCartRepository shoppingCartRepository;

  @Autowired
  ClientRepository clientRepository;


  @Override
  public List<ShoppingCartDTO> getAllShoppingCart() {
    return shoppingCartRepository.findAll().stream().map(shoppingCart -> new ShoppingCartDTO(shoppingCart)).collect(toList());
  }

  @Override
  public ShoppingCartDTO getShoppingCartById(Long id) {
    return new ShoppingCartDTO(shoppingCartRepository.findById(id).get());

  }

  @Override
  public void postShoppingCart(Authentication authentication) {
    Client clientConnected = clientRepository.findByEmail(authentication.getName());

  }


}
