package com.shoppingCart.shoppingCart.controllers;

import com.shoppingCart.shoppingCart.dtos.ProductCreateDTO;
import com.shoppingCart.shoppingCart.dtos.ProductDTO;
import com.shoppingCart.shoppingCart.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    public ProductService productService;

    @PostMapping("/admin/products")
    public ResponseEntity<Object> create(Authentication authentication,@RequestBody ProductCreateDTO productCreateDTO){
        //validar admin?
        return productService.create(productCreateDTO);
    }
    @GetMapping("/admin/products")
    public Set<ProductDTO> readAll(){
        return productService.readAll();
    }
    @GetMapping("/products")
    public Set<ProductDTO> read(){
        return productService.read();
    }
    @PatchMapping("/admin/products/{id}")
    public void update(@PathVariable Long id, @RequestBody ProductCreateDTO productCreateDTO){
        productService.update(id, productCreateDTO);
    }
    @PatchMapping("/admin/products/setstatus/{id}")
    public void setStatus(@PathVariable long id){
        productService.setStatus(id);
    }
}
