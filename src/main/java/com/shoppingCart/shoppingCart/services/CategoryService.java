package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.dtos.CategoryDTO;
import com.shoppingCart.shoppingCart.models.Category;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface CategoryService {
    ResponseEntity<Object> create(String name);

    Set<CategoryDTO> read();

    void update(String name, Long id);

    void setStatus(Long id);

    Category findById(Long id);
}
