package com.shoppingCart.shoppingCart.models;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue (strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    @ApiModelProperty(notes = "Product ID", example = "1", required = true)
    private Long id;
    @ApiModelProperty(notes = "Product Name", example = "Gaseosa", required = true)
    private String name;
    @ApiModelProperty(notes = "Product Price", example = "200", required = true)
    private Double price;
    @ApiModelProperty(notes = "Product Stock", example = "20", required = true)
    private Integer stock;
    @ApiModelProperty(notes = "Product Description", example = "CocaCola", required = true)
    private String description;
    @ApiModelProperty(notes = "Product Status", example = "true", required = true)
    private boolean status;
    @ManyToOne ( fetch = FetchType.EAGER)
    @ApiModelProperty(notes = "Product Categoty", example =  "Bebidas", required = true)
    private Category category;
    @OneToMany ( fetch=FetchType.EAGER)
    @ApiModelProperty(notes = "Product Loads", example = "", required = true)
    private Set<ProductLoad> productLoads=new HashSet<>();
    public Product() {
    }

    public Product(String name, Double price, Integer stock, String description, Category category) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.status=true;
        this.category=category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
