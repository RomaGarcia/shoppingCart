package com.shoppingCart.shoppingCart.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue (strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
    private String description;
    private boolean status;
    @ManyToOne
    private Categories category;
    @OneToMany ( fetch=FetchType.EAGER)
    private Set<ProductLoad> productLoads=new HashSet<>();
    public Product() {
    }

    public Product(String name, Double price, Integer stock, String description, Categories category) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.status=true;
        this.category=category;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Set<ProductLoad> getProductLoads() {
        return productLoads;
    }

    public void setProductLoads(Set<ProductLoad> productLoads) {
        this.productLoads = productLoads;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
