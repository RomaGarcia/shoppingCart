package com.shoppingCart.shoppingCart.dtos;

import com.shoppingCart.shoppingCart.models.Product;

public class ProductLoadCreateDTO {
    private Long id;
    private Product product;
    private Integer amount;

    public ProductLoadCreateDTO() {
    }

    public ProductLoadCreateDTO(Long id, Product product, Integer amount) {
        this.id = id;
        this.product = product;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
