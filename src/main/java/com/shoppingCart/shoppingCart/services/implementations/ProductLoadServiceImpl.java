package com.shoppingCart.shoppingCart.services.implementations;

import com.shoppingCart.shoppingCart.dtos.ProductLoadCreateDTO;
import com.shoppingCart.shoppingCart.models.ProductLoad;
import com.shoppingCart.shoppingCart.repositories.ProductLoadRepository;
import com.shoppingCart.shoppingCart.services.ProductLoadService;
import com.shoppingCart.shoppingCart.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductLoadServiceImpl implements ProductLoadService {
    @Autowired
    public ProductLoadRepository productLoadRepository;
    //@Autowired
    //public ShoppingCartService shoppingCartService;
    @Override
    public ResponseEntity<Object> add(ProductLoadCreateDTO productLoadCreateDTO){
        ProductLoad productLoad= new ProductLoad(productLoadCreateDTO.getProduct(), productLoadCreateDTO.getAmount(), productLoadCreateDTO.getShoppingCart());
        return new ResponseEntity<>("añadido", HttpStatus.CREATED);
    }
    @Override
    public void setAmount(Long id, Integer amount){
        ProductLoad productLoad = productLoadRepository.findById(id).get();
        productLoad.setAmount(productLoad.getAmount()+amount);
    }
    @Override
    public void remove(Long id){
        ProductLoad productLoad = productLoadRepository.findById(id).get();
        //shoppingCartService.remove(productLoad.getId(), id);
        productLoad.setShoppingCart(null);

       // productLoadRepository.delete(productLoad);

    }


}
