package com.example.API.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.dto.ProductDTO;
import com.example.API.entity.Category;
import com.example.API.entity.Product;
import com.example.API.repository.CategoryRepository;
import com.example.API.repository.ProductRepository;
import com.example.API.service.ProductService;

@Service
public class ProductImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public ProductDTO findOneById(Long id) {		
		Product product = productRepository.findById(id).orElseThrow(()->new IllegalStateException("Not found product"));
		return ProductDTO.toDTO(product);
	}

	@Override
	public List<Product> findAllByCategory(Long categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(()->new IllegalStateException("Not found product"));
		return productRepository.findAllByCategory(category);
	}

	@Override
	public ProductDTO save(ProductDTO productDTO) {
		Product product = new Product();
		if (productDTO.getId() != null) {
			Product oldProduct = productRepository.findById(productDTO.getId()).orElseThrow(()->new IllegalStateException("Not found product"));;
			System.out.println(oldProduct.getCreatedDate());
			product = ProductDTO.toEntity(productDTO, oldProduct);
			product.setModifiedDate(new Date());
		} else {
			product = ProductDTO.toEntity(productDTO);
			product.setCreatedDate(new Date());
			product.setQuantity(0);
		}
		Category category = categoryRepository.findOneByCode(productDTO.getCategoryCode());
		product.setCategory(category);
		product = productRepository.save(product);
		return ProductDTO.toDTO(product);
	}

	@Override
	public boolean delete(Long id) {
		Product product = productRepository.findById(id).orElseThrow(()->new IllegalStateException("Not found product"));
		productRepository.delete(product);
		return true;
	}

}
