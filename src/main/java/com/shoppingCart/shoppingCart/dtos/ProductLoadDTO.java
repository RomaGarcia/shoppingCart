package com.shoppingCart.shoppingCart.dtos;

import com.shoppingCart.shoppingCart.models.ProductLoad;

public class ProductLoadDTO {
    private Long id;
    private ProductDTO productDTO;
    private Integer quantity;

    public ProductLoadDTO() {
    }

    public ProductLoadDTO(ProductLoad productLoad) {
        this.id = productLoad.getId();
        this.productDTO = new ProductDTO(productLoad.getProduct());
        this.quantity = productLoad.getQuantity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
