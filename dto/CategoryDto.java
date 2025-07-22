package com.product.product.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CategoryDto {

	Long id;
	String name;
	@JsonIgnore
	List<ProductDto> products;

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

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}

	public CategoryDto(Long id, String name, List<ProductDto> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}

	public CategoryDto() {
		super();
	}

	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", name=" + name + ", products=" + products + "]";
	}

}
