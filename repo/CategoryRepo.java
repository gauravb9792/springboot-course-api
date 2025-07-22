package com.product.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.product.entity.CategoryEntity;
@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity     findByName(String name);
}
