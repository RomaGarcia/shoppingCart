package com.shoppingCart.shoppingCart.repositories;

import com.shoppingCart.shoppingCart.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository <Category, Long> {

    Category findByName(String name);
}
