package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.dtos.ProductLoadCreateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface ProductLoadService {






    ResponseEntity<Object> add(Long productId, Integer amount, Authentication authentication);

    void setAmount(Long id, Integer amount);

    void remove(Long id);
}
