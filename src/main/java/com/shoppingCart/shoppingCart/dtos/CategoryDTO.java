package com.shoppingCart.shoppingCart.dtos;

import com.shoppingCart.shoppingCart.models.Category;

public class CategoryDTO {

    public Long id;
    public String name;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
