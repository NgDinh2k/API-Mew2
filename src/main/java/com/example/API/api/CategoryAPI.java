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

import com.example.API.dto.CategoryDTO;
import com.example.API.entity.Category;
import com.example.API.service.CategoryService;



@CrossOrigin
@RestController
@RequestMapping("/api/category")
public class CategoryAPI {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "")
	public List<Category> getAll() {
		return categoryService.findAll();
	}
	
	@PostMapping(value = "")
	public CategoryDTO createCategory(@RequestBody CategoryDTO category) {
		return categoryService.save(category);
	}

	@PutMapping(value = "/{id}")
	public CategoryDTO updateCategory(@RequestBody CategoryDTO category, @PathVariable("id") long id) {
		category.setId(id);
		return categoryService.save(category);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteProduct(@PathVariable("id") long id) {
		categoryService.delete(id);
	}
	
	@GetMapping(value = "/{id}")
	public CategoryDTO getByID(@PathVariable("id") long id) {
		return categoryService.findOneById(id);
	}
}
