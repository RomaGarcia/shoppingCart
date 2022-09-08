package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.dtos.ProductCreateDTO;
import com.shoppingCart.shoppingCart.dtos.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface ProductService {
    ResponseEntity create(ProductCreateDTO productCreateDTO);

    Set<ProductDTO> read();

    Set<ProductDTO> readAll();

    void update(Long id, ProductCreateDTO productCreateDTO);

    void setStatus(Long id);
}
