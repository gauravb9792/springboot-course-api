package com.product.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.product.dto.CategoryDto;

@Service
public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);
	
	List<CategoryDto> getAllCategories();
	
	//CategoryDto getProductByCategoryId(Long id, ProductDto productDto);
	
	
	CategoryDto getCategoryByName(String name);
}
