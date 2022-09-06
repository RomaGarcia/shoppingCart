package com.shoppingCart.shoppingCart.dtos;

import com.shoppingCart.shoppingCart.models.Product;
import com.shoppingCart.shoppingCart.models.ShoppingCart;

public class ProductLoadCreateDTO {
    private Long id;
    private Product product;
    private Integer amount;
    private ShoppingCart shoppingCart;

    public ProductLoadCreateDTO() {
    }

    public ProductLoadCreateDTO(Product product, Integer amount, ShoppingCart shoppingCart) {
        this.product = product;
        this.amount = amount;
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
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
