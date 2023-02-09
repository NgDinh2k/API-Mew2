package com.example.API.dto;


import com.example.API.entity.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO extends AbstractDTO<ProductDTO>{

	private String name;
	private String image;
	private double price;
	private int quantity;
	private String categoryCode;
	
	public static ProductDTO toDTO(Product entity) {
		ProductDTO dto = new ProductDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setImage(entity.getImage());
		dto.setPrice(entity.getPrice());
		dto.setQuantity(entity.getQuantity());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	public static Product toEntity(ProductDTO dto) {
		Product entity = new Product();
		entity.setName(dto.getName());
		entity.setImage(dto.getImage());
		entity.setPrice(dto.getPrice());
		entity.setQuantity(dto.getQuantity());		
		return entity;
	}
	
	public static Product toEntity(ProductDTO dto, Product entity) {
		entity.setName(dto.getName());
		entity.setImage(dto.getImage());
		entity.setPrice(dto.getPrice());
		entity.setQuantity(dto.getQuantity());		
		return entity;
	}
}
