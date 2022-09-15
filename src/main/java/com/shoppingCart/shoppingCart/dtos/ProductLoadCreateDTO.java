package com.shoppingCart.shoppingCart.dtos;

import com.shoppingCart.shoppingCart.models.Product;
import com.shoppingCart.shoppingCart.models.ShoppingCart;

public class ProductLoadCreateDTO {
    private Long id;
    private Product product;
    private Integer quantity;
    private ShoppingCart shoppingCart;

    public ProductLoadCreateDTO() {
    }

    public ProductLoadCreateDTO(Product product, Integer quantity, ShoppingCart shoppingCart) {
        this.product = product;
        this.quantity = quantity;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductLoadCreateDTO{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", shoppingCart=" + shoppingCart +
                '}';
    }
}
