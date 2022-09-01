package com.shoppingCart.shoppingCart.repositories;

import com.shoppingCart.shoppingCart.models.ProductLoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductLoadRepository extends JpaRepository <ProductLoad, Long> {
}
