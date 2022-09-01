package com.shoppingCart.shoppingCart.controllers;


import com.shoppingCart.shoppingCart.dtos.CategoryDTO;
import com.shoppingCart.shoppingCart.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @PostMapping("/admin/category/{name}")
    public ResponseEntity<Object> create(Authentication authentication, @PathVariable String name){
        //validar admin
        return categoryService.create(name);
    }
    @PatchMapping("/admin/category")
    public void update(Authentication authentication, @RequestParam String name, @RequestParam Long id){
        //validasr admin
        categoryService.update(name, id);
    }
    @GetMapping("/admin/category")
    public Set<CategoryDTO> read(Authentication authentication){
        return categoryService.read();
    }
    @PatchMapping("/admin/category{id}")
    public void setStatus(Authentication authentication, @PathVariable Long id){

    }
}
