package com.shoppingCart.shoppingCart.models;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue (strategy= GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    @ApiModelProperty(notes = "Product Categoty ID", example =  "1", required = false)
    private Long id;
    @ApiModelProperty(notes = "Product Categoty name", example =  "Bebidas", required = true)
    private String name;
    @OneToMany ( fetch = FetchType.EAGER)
    private Set<Product> product=new HashSet<>();
    @ApiModelProperty(notes = "Product Categoty status", example =  "true", required = true)
    private boolean status;
    public Category() {
    }

    public Category(String name) {
        this.status=true;
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
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

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
