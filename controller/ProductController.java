package com.product.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.product.dto.ProductDto;
import com.product.product.service.ProductServiceImp;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductServiceImp productServiceImp;

	@PostMapping("/")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
		ProductDto product = productServiceImp.createProduct(productDto);
		return new ResponseEntity<ProductDto>(product, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		List<ProductDto> product = productServiceImp.getAllProducts();
		return new ResponseEntity<List<ProductDto>>(product, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
		ProductDto product = productServiceImp.getProductById(id);
		return new ResponseEntity<ProductDto>(product, HttpStatus.OK);

	}

//public	List<ProductDto> getAllProductsByCategoryId(Long id);
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductDto> deleteProduct(@PathVariable Long id) {
		ProductDto product = productServiceImp.deleteProduct(id);
		return new ResponseEntity<ProductDto>(product, HttpStatus.OK);

	}
}
