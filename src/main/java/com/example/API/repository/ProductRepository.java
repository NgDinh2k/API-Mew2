package com.example.API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.API.entity.Product;
import com.example.API.entity.Category;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findAllByCategory(Category category);
}
