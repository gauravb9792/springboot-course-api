package com.product.product.dto;


public class ProductDto {

    private Long id;
    private String name;
    private Long price;
    private Long categoryId;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, Long price, Long categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ProductDto [id=" + id + ", name=" + name + ", price=" + price + ", categoryId=" + categoryId + "]";
    }
}
