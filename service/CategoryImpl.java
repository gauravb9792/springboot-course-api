package com.product.product.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product.dto.CategoryDto;
import com.product.product.entity.CategoryEntity;
import com.product.product.entity.ProductEntity;
import com.product.product.repo.CategoryRepo;

@Service
public class CategoryImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	ModelMapper modelMapper;

//	@Override
//	public CategoryDto createCategory(CategoryDto categoryDto) {
//		CategoryEntity categoryEntity = modelMapper.map(categoryDto, CategoryEntity.class);
//
//		// Set back-reference for products (one-to-many)
//		List<ProductEntity> products = categoryEntity.getProducts();
//		if (products != null) {
//			for (int i = 0; i < products.size(); i++) {
//				products.get(i).setCategoryEntity(categoryEntity);
//			}
//		}
//
//		// Save category
//		categoryEntity = categoryRepo.save(categoryEntity);
//		return modelMapper.map(categoryEntity, CategoryDto.class);
//	}

	
	
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
	    // Map DTO to entity
	    CategoryEntity categoryEntity = modelMapper.map(categoryDto, CategoryEntity.class);
	    
	    // Don’t manually set product references; you just want to create a category
	    categoryEntity.setProducts(null); // ensure no products are set

	    // Save category
	    categoryEntity = categoryRepo.save(categoryEntity);

	    // Map back to DTO
	    return modelMapper.map(categoryEntity, CategoryDto.class);
	}

	
	
//	@Override
//	public List<CategoryDto> getAllCategories() {
//		List<CategoryEntity> category = categoryRepo.findAll();
//		List<CategoryDto> newCategory = new ArrayList<CategoryDto>();
//
//		for (int i = 0; i < category.size(); i++) {
//			CategoryDto dto = modelMapper.map(category.get(i), CategoryDto.class);
//			newCategory.add(dto);
//
//		}
//		return newCategory;
//
//	}
	
	
	@Override
	public List<CategoryDto> getAllCategories() {
	    List<CategoryEntity> categoryList = categoryRepo.findAll();
	    List<CategoryDto> newCategoryList = new ArrayList<>();

	    for (int i = 0; i < categoryList.size(); i++) {
	        CategoryDto dto = new CategoryDto();
	        dto.setId(categoryList.get(i).getId());
	        dto.setName(categoryList.get(i).getName());
	        // Do NOT set products
	        newCategoryList.add(dto);
	    }
	    return newCategoryList;
	}


	@Override
	public CategoryDto getCategoryByName(String name) {
	CategoryEntity category=categoryRepo.findByName(name);
		return modelMapper.map(category, CategoryDto.class);
	}

	



}
