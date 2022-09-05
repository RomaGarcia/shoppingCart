package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.dtos.ProductLoadCreateDTO;
import org.springframework.http.ResponseEntity;

public interface ProductLoadService {
    ResponseEntity<Object> create(ProductLoadCreateDTO productLoadCreateDTO);
}
