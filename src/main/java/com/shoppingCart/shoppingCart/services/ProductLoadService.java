package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.dtos.ProductLoadCreateDTO;
import org.springframework.http.ResponseEntity;

public interface ProductLoadService {




    ResponseEntity<Object> add(Long productId, Integer amount, Long shoppingCartId);

    void setAmount(Long id, Integer amount);

    void remove(Long id);
}
