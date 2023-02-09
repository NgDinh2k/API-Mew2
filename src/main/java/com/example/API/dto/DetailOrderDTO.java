package com.example.API.dto;


import com.example.API.entity.DetailOrder;
import com.example.API.entity.entityPK.DetailOrderPK;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DetailOrderDTO {

	private Long orderID;
	private Long productId;
	private String productName;
	private String productImage;
	private Integer quantity;
	private Double price;

	
	public static DetailOrderDTO toDTO(DetailOrder entity) {
		DetailOrderDTO dto = new DetailOrderDTO();
		dto.setOrderID(entity.getOrder().getId());
		dto.setProductId(entity.getProduct().getId());
		dto.setProductName(entity.getProduct().getName());
		dto.setProductImage(entity.getProduct().getImage());
		dto.setPrice(entity.getPrice());
		dto.setQuantity(entity.getQuantity());
		return dto;
	}
	
	public static DetailOrder toEntity(DetailOrderDTO dto) {
		DetailOrder entity = new DetailOrder();
		DetailOrderPK id = new DetailOrderPK(dto.getOrderID(), dto.getProductId());
		entity.setId(id);
		entity.setPrice(dto.getPrice());
		entity.setQuantity(dto.getQuantity());
		return entity;
	}
}
