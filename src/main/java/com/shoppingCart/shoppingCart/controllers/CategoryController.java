package com.shoppingCart.shoppingCart.controllers;


import com.shoppingCart.shoppingCart.dtos.CategoryDTO;
import com.shoppingCart.shoppingCart.services.CategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;


    @ApiOperation(value = "Create a category")
    @ApiResponses(value = {
           @ApiResponse(code = 201, message = "created")
    })
    @PostMapping("/admin/category/{name}")
    public ResponseEntity<Object> create(Authentication authentication, @PathVariable @ApiParam(name = "name", value = "Category name", example = "Bebidas") String name){

        return categoryService.create(name);
    }
    @ApiOperation(value = "Update a category")
    @PatchMapping("/admin/category")
    public void update(Authentication authentication, @RequestParam @ApiParam(name = "name", value = "Category name", example = "Gaseosa") String name, @RequestParam @ApiParam(name = "id", value = "Category id", example = "1") Long id){

        categoryService.update(name, id);
    }
    @ApiOperation(value = "get all categories")
    @GetMapping("/admin/category")
    public Set<CategoryDTO> read(Authentication authentication){
        return categoryService.read();
    }
    @ApiOperation(value = "cancel/activate category by id")
    @PatchMapping("/admin/category/{id}")
    public void setStatus(Authentication authentication, @PathVariable  @ApiParam(name = "id", value = "Category id", example = "1") Long id){

    }
}
