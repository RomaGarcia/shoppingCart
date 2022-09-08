package com.shoppingCart.shoppingCart.repositories;

import com.shoppingCart.shoppingCart.dtos.ProductCreateDTO;
import com.shoppingCart.shoppingCart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;

import java.util.Set;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Set<Product> findByStatusAndStockGreaterThan(boolean statusRequired, Integer stockRequired);

}
