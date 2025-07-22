package com.product.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.product.dto.ProductDto;

@Service
public interface ProductService {

	
	ProductDto createProduct(ProductDto productDto);
	
	List<ProductDto> getAllProducts();
	
	ProductDto getProductById(Long id);
	
	List<ProductDto> getAllProductsByCategoryId(Long id);
	
	ProductDto deleteProduct(Long id);
	
}
