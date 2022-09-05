package com.shoppingCart.shoppingCart.services.implementations;

import com.shoppingCart.shoppingCart.dtos.ShoppingCartDTO;
import com.shoppingCart.shoppingCart.models.Client;
import com.shoppingCart.shoppingCart.repositories.ClientRepository;
import com.shoppingCart.shoppingCart.repositories.ShoppingCartRepository;
import com.shoppingCart.shoppingCart.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class ShoppingCartServiceImpl implements ShoppingCartService {

  @Autowired
  ShoppingCartRepository shoppingCartRepository;

  @Autowired
  ClientRepository clientRepository;


  @Override
  public ShoppingCartDTO getShoppingCartById(Long id) {
    return new ShoppingCartDTO(shoppingCartRepository.findById(id).get());

  }

  @Override
  public ResponseEntity<Object> postShoppingCart(Authentication authentication) {
   // Client clientConnected = clientRepository.find

    return null;
  }


}




//    @PostMapping("/clients/current/shoppingCart")
//    public ResponseEntity<Object> postCard(Authentication authentication){
//        Client clientConneted = clientRepository.findByEmail(authentication.getName());
//
//        if(repo.findByTypeAndClient(type, clientConneted).size() > 2){
//            return new ResponseEntity<>("No puedes agregar más tarjetas de tipo "+type, HttpStatus.FORBIDDEN);
//        }
//
//        String numero1 = ((Integer)getRandomNumber(1001, 10000)).toString();
//        String numero2 = ((Integer)getRandomNumber(1001, 10000)).toString();
//        String numero3 = ((Integer)getRandomNumber(1001, 10000)).toString();
//        int cvv = getRandomNumber(101, 1000);
//
//        Card card1 = new Card (type, color, "8888" + "-" + numero1 + "-"+ numero2 +"-"+numero3, cvv);
//
//        clientConneted.addCard(card1);
//
//        repo.save(card1); //guardamos la cuenta creada
//
//        return new ResponseEntity<>("Tarjeta creada", HttpStatus.CREATED);
//    }