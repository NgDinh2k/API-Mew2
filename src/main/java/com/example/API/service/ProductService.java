package com.example.API.service;

import java.util.List;

import com.example.API.dto.ProductDTO;
import com.example.API.entity.Product;

public interface ProductService {
	public List<Product> findAll();
		
	public List<Product> findAllByCategory(Long categoryId);
	
	public ProductDTO findOneById(Long id);
	
	public ProductDTO save(ProductDTO productDTO);
	
	public boolean delete(Long id);
}
