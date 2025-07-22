package com.product.product.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product.dto.ProductDto;
import com.product.product.entity.CategoryEntity;
import com.product.product.entity.ProductEntity;
import com.product.product.repo.CategoryRepo;
import com.product.product.repo.ProductRepo;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	ProductRepo productRepo;
	@Autowired
	CategoryRepo categoryRepo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ProductDto createProduct(ProductDto productDto) {

		CategoryEntity category = categoryRepo.findById(productDto.getCategoryId())
				.orElseThrow(() -> new RuntimeException("Category not found"));
		ProductEntity products = modelMapper.map(productDto, ProductEntity.class);

		products.setId(null); // just to be safe
		products.setCategoryEntity(category);
		products = productRepo.save(products);
		return modelMapper.map(products, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<ProductEntity> products = productRepo.findAll();
		List<ProductDto> list = new ArrayList<>();

		for (int i = 0; i < products.size(); i++) {
			ProductDto dto = modelMapper.map(products.get(i), ProductDto.class);

			list.add(dto);
		}
		return list;
	}

	@Override
	public ProductDto getProductById(Long id) {
		ProductEntity product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("ID NOT FOUND"));

		return modelMapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProductsByCategoryId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto deleteProduct(Long id) {

		ProductEntity product = productRepo.findById(id).orElseThrow(() -> new RuntimeException());

		productRepo.deleteById(id);

		return modelMapper.map(product, ProductDto.class);

	}

}
