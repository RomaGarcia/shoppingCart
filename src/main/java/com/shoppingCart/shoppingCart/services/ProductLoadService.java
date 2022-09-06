package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.dtos.ProductLoadCreateDTO;
import org.springframework.http.ResponseEntity;

public interface ProductLoadService {


    ResponseEntity<Object> add(ProductLoadCreateDTO productLoadCreateDTO);

    void setAmount(Long id, Integer amount);

    void remove(Long id);
}
