package com.example.API.dto;


import com.example.API.entity.Category;

import lombok.Getter;
import lombok.Setter;;


@Getter
@Setter
public class CategoryDTO extends AbstractDTO<CategoryDTO> {

	private String code;
	private String name;
	
	public static Category toEntity(CategoryDTO dto) {
		Category entity = new Category();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}
	
	public static CategoryDTO toDTO(Category entity) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	public static Category toEntity(Category entity, CategoryDTO dto) {
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}
}
