package com.example.API.dto;

import com.example.API.entity.Cart;
import com.example.API.entity.entityPK.CartPK;

import lombok.Data;

@Data
public class CartDTO {
	private Long userId;
	private Long productId;
	private String productName;
	private String productImage;
	private Integer quantity;
	private Double price;

	public static CartDTO toDTO(Cart entity) {
		CartDTO dto = new CartDTO();
		dto.setUserId(entity.getUser().getId());
		dto.setProductId(entity.getProduct().getId());
		dto.setProductName(entity.getProduct().getName());
		dto.setProductImage(entity.getProduct().getImage());
		dto.setPrice(entity.getPrice());
		dto.setQuantity(entity.getQuantity());
		return dto;
	}

	public static Cart toEntity(CartDTO dto) {
		Cart entity = new Cart();
		CartPK id = new CartPK(dto.getProductId(), dto.getUserId());
		entity.setId(id);
		entity.setPrice(dto.getPrice());
		entity.setQuantity(dto.getQuantity());
		return entity;
	}
}
