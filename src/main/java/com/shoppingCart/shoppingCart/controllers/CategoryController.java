package com.shoppingCart.shoppingCart.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/admin/category")
    public ResponseEntity<Object> create(Authentication authentication, @PathVariable String name){
        //validar admin
        return categoryService.create(name);
    }
}
