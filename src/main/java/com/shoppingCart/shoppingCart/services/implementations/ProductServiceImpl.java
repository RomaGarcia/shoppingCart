package com.shoppingCart.shoppingCart.services.implementations;

import com.shoppingCart.shoppingCart.dtos.ProductCreateDTO;
import com.shoppingCart.shoppingCart.dtos.ProductDTO;
import com.shoppingCart.shoppingCart.models.Product;
import com.shoppingCart.shoppingCart.models.ProductLoad;
import com.shoppingCart.shoppingCart.repositories.CategoryRepository;
import com.shoppingCart.shoppingCart.repositories.ProductRepository;
import com.shoppingCart.shoppingCart.services.CategoryService;
import com.shoppingCart.shoppingCart.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public CategoryService categoryService;
    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public ResponseEntity create(ProductCreateDTO productCreateDTO){

        if (productCreateDTO.getPrice()<=0 || productCreateDTO.getStock()<0){
            return new ResponseEntity<>("Revise los datos ingresados", HttpStatus.FORBIDDEN);
        }
        Product product = new Product(productCreateDTO.getName(), productCreateDTO.getPrice(), productCreateDTO.getStock(), productCreateDTO.getDescription(), categoryRepository.findByName(productCreateDTO.getCategory()));
        productRepository.save(product);
        return new ResponseEntity<>("Producto creado", HttpStatus.CREATED);
    }
    @Override
    public Set<ProductDTO> read(){
        return productRepository.findByStatusAndStockGreaterThan(true,0).stream().map(ProductDTO::new).collect((toSet()));
    }
    @Override
    public Set<ProductDTO> readAll(){
        return productRepository.findAll().stream().map(ProductDTO::new).collect((toSet()));
    }
    @Override
    public void update(Long id, ProductCreateDTO productCreateDTO){
        Product product= productRepository.findById(id).get();
        if (productCreateDTO.getStock()!=null){
            product.setStock(productCreateDTO.getStock());
        }
        if (productCreateDTO.getName()!=null){
            product.setName(productCreateDTO.getName());
        }
        if (productCreateDTO.getPrice()!=null){
            product.setPrice(productCreateDTO.getPrice());
        }
        if (productCreateDTO.getDescription()!=null){
            product.setDescription(productCreateDTO.getDescription());
        }
        if (productCreateDTO.getCategory()!=null){
            product.setCategory(categoryRepository.findByName(productCreateDTO.getCategory()));
        }
        productRepository.save(product);
    }
    @Override
    public void setStatus(Long id){
        Product product=productRepository.findById(id).get();
        product.setStatus(!product.isStatus());
        productRepository.save(product);
    }
    @Override
    public boolean discount(Set<ProductLoad> productLoads){
        for (ProductLoad productLoad: productLoads) {
            Product product=productLoad.getProduct();
            if (productLoad.getQuantity()>product.getStock()) {
                return false;
            }
            product.setStock(product.getStock()-productLoad.getQuantity());

        }
        productRepository.saveAll(productLoads.stream().map(productLoad -> productLoad.getProduct()).collect(toList()));
        return true;
    }

}
