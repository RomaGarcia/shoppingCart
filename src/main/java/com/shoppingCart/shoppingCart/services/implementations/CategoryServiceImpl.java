package com.shoppingCart.shoppingCart.services.implementations;

import com.shoppingCart.shoppingCart.dtos.CategoryDTO;
import com.shoppingCart.shoppingCart.models.Category;
import com.shoppingCart.shoppingCart.repositories.CategoryRepository;
import com.shoppingCart.shoppingCart.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;
    @Override
    public ResponseEntity<Object> create(String name){
        Category category = new Category(name);
        categoryRepository.save(category);
        return new ResponseEntity<>("categoria crada", HttpStatus.CREATED);
    }
    @Override
    public Set<CategoryDTO> read(){
        return categoryRepository.findAll().stream().map(CategoryDTO::new).collect((toSet()));
    }
    @Override
    public void update(String name, Long id){
        Category category = categoryRepository.findById(id).get();
        category.setName(name);
        categoryRepository.save(category);
    }
    @Override
    public void setStatus(Long id){
        Category category = categoryRepository.findById(id).get();
        category.setStatus(!category.isStatus());
        categoryRepository.save(category);
    }
    @Override
    public Category findById(Long id){
        return categoryRepository.findById(id).get();
    }

}
