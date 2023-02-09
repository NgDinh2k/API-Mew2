package com.example.API.service;

import java.util.List;

import com.example.API.dto.CategoryDTO;
import com.example.API.entity.Category;



public interface CategoryService {

	public List<Category> findAll();
	
	public CategoryDTO findOneById(Long id);
	
	public CategoryDTO save(CategoryDTO categoryDTO);
	
	public boolean delete(Long id);
}
