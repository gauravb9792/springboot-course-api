package com.product.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.product.dto.CategoryDto;
import com.product.product.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto) {
		CategoryDto category = categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(category, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategories() {
		List<CategoryDto> category = categoryService.getAllCategories();
		return new ResponseEntity<>(category, HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<CategoryDto> getCategoryByName(@PathVariable String name)
	{
		CategoryDto category = categoryService.getCategoryByName(name);
		return new ResponseEntity<CategoryDto>(category, HttpStatus.OK);
	}
}
