package com.shoppingCart.shoppingCart.models;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ProductLoad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
     @ApiModelProperty(notes = "Product Load Id", example =  "1")
    private Long id;
    @ManyToOne( fetch = FetchType.EAGER)
    private Product product;
     @ApiModelProperty(notes = "Product Load cuantity", example =  "2", required = true)
    private Integer amount;
    @ManyToOne ( fetch = FetchType.EAGER)
    private ShoppingCart shoppingCart;

    public ProductLoad() {
    }

    public ProductLoad(Product product, Integer amount, ShoppingCart shoppingCart) {
        this.shoppingCart=shoppingCart;
        this.product = product;
        this.amount = amount;
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

    @Override
    public String toString() {
        return "ProductLoad{" +
                "id=" + id +
                ", product=" + product +
                ", amount=" + amount +
                '}';
    }
}
