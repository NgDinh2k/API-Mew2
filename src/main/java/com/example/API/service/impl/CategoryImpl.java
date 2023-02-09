package com.example.API.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.dto.CategoryDTO;
import com.example.API.entity.Category;
import com.example.API.repository.CategoryRepository;
import com.example.API.service.CategoryService;

@Service
public class CategoryImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public CategoryDTO findOneById(Long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Not found category"));
		return CategoryDTO.toDTO(category);
	}

	@Override
	public CategoryDTO save(CategoryDTO categoryDTO) {
		Category category = new Category();
		if (categoryDTO.getId() != null) {
			Category oldCategory = categoryRepository.findById(categoryDTO.getId())
					.orElseThrow(() -> new IllegalStateException("Not found category"));
			category = CategoryDTO.toEntity(oldCategory, categoryDTO);
			category.setModifiedDate(new Date());
		} else {
			category = CategoryDTO.toEntity(categoryDTO);
			category.setCreatedDate(new Date());
		}
		category = categoryRepository.save(category);
		return CategoryDTO.toDTO(category);
	}

	@Override
	public boolean delete(Long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Not found category"));
		categoryRepository.delete(category);
		return true;
	}
}
