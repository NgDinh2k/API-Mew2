package com.example.API.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API.dto.ProductDTO;
import com.example.API.entity.Product;
import com.example.API.service.ProductService;



@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductAPI {
	@Autowired
	private ProductService productService;

	@PostMapping(value = "")
	public ProductDTO createProduct(@RequestBody ProductDTO product) {
		return productService.save(product);
	}

	@PutMapping(value = "/{id}")
	public ProductDTO updateProduct(@RequestBody ProductDTO product, @PathVariable("id") long id) {
		product.setId(id);
		return productService.save(product);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteProduct(@PathVariable("id") long id) {
		productService.delete(id);
	}
	
	@GetMapping(value = "")
	public List<Product> getAll() {
		return productService.findAll();
	}

	@GetMapping(value = "/{id}")
	public ProductDTO getByID(@PathVariable("id") long id) {
		return productService.findOneById(id);
	}

	@GetMapping(value = "/category/{id}")
	public List<Product> getAllByCategory(@PathVariable("id") long id) {
		return productService.findAllByCategory(id);
	}
}
