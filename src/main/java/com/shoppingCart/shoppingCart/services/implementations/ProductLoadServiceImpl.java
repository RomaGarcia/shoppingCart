package com.shoppingCart.shoppingCart.services.implementations;

import com.shoppingCart.shoppingCart.dtos.ProductLoadCreateDTO;
import com.shoppingCart.shoppingCart.models.ProductLoad;
import com.shoppingCart.shoppingCart.repositories.ProductLoadRepository;
import com.shoppingCart.shoppingCart.services.ProductLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductLoadServiceImpl implements ProductLoadService {
    @Autowired
    public ProductLoadRepository productLoadRepository;
    @Override
    public ResponseEntity<Object> create(ProductLoadCreateDTO productLoadCreateDTO){
        ProductLoad productLoad= new ProductLoad(productLoadCreateDTO.getProduct(), productLoadCreateDTO.getAmount());
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }

}
