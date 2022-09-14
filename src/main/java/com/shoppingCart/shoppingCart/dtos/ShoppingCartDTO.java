package com.shoppingCart.shoppingCart.dtos;

import com.shoppingCart.shoppingCart.models.Client;
import com.shoppingCart.shoppingCart.models.ProductLoad;
import com.shoppingCart.shoppingCart.models.ShoppingCart;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ShoppingCartDTO {

    public Double price;

    public Set<ProductLoadDTO> productLoads= new HashSet<>();
    public ShoppingCartDTO(ShoppingCart shoppingCart) {
        this.productLoads=shoppingCart.getProductLoans().stream().map(productLoad -> new ProductLoadDTO(productLoad)).collect(Collectors.toSet());
        this.price= shoppingCart.getPrice();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<ProductLoadDTO> getProductLoads() {
        return productLoads;
    }

    public void setProductLoads(Set<ProductLoadDTO> productLoads) {
        this.productLoads = productLoads;
    }
}
