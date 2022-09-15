package com.shoppingCart.shoppingCart.controllers;

import com.shoppingCart.shoppingCart.dtos.ProductCreateDTO;
import com.shoppingCart.shoppingCart.dtos.ProductDTO;
import com.shoppingCart.shoppingCart.services.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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


    @ApiOperation(value = "registrar un nuevo producto")
    @ApiResponses(value = {
            @ApiResponse(code = 403, message = "Revisar datos"),
            @ApiResponse(code = 201, message = "producto creado")
    })
    @PostMapping("/admin/products")
    public ResponseEntity<Object> create(@RequestBody ProductCreateDTO productCreateDTO){

        return productService.create(productCreateDTO);
    }

    @ApiOperation(value = "Lista todos los productos. Se requiere permiso de admin")
    @GetMapping("/admin/products")
    public Set<ProductDTO> readAll(){
        return productService.readAll();
    }

    @ApiOperation(value = "Lista todos los productos activos.")
    @GetMapping("/products")
    public Set<ProductDTO> read(){
        return productService.read();
    }

    @ApiOperation(value = "Edita datos de un producto. Se requiere permiso de admin")
    @PatchMapping("/admin/products/{id}")
    public void update(@PathVariable @ApiParam(name = "id", value = "id del producto", example = "1")Long id, @RequestBody @ApiParam(name = "productDTO", value = "Informacion del nuevo producto") ProductCreateDTO productCreateDTO){
        productService.update(id, productCreateDTO);
    }

    @ApiOperation(value = "Anula/activa un producto. Se requiere permiso de admin")
    @PatchMapping("/admin/products/setstatus/{id}")
    public void setStatus(@PathVariable @ApiParam(name = "id", value = "id del producto", example = "1")long id){
        productService.setStatus(id);
    }
}
