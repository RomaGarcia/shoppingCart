package com.shoppingCart.shoppingCart.dtos;

import com.shoppingCart.shoppingCart.models.Category;

public class ProductCreateDTO {
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
    private String description;
    private String category;

    public ProductCreateDTO() {
    }

    public ProductCreateDTO( String name, Double price, Integer stock, String description, String category) {

        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.category=category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
