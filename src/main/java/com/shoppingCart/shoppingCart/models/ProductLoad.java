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
     @ApiModelProperty(notes = "Cantidad de productos cargados", example =  "2", required = true)
    private Integer quantity;
    @ManyToOne ( fetch = FetchType.EAGER)
    private ShoppingCart shoppingCart;

    public ProductLoad() {
    }

    public ProductLoad(Product product, Integer quantity, ShoppingCart shoppingCart) {
        this.shoppingCart=shoppingCart;
        this.product = product;
        this.quantity = quantity;
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
        return "ProductLoad{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
