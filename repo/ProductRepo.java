package com.product.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.product.entity.ProductEntity;
@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {

	
}
