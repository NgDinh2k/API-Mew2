package com.example.API.dto;

import com.example.API.entity.Order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO extends AbstractDTO<OrderDTO> {
	private String status;
	private Long user_id;
	
	public static OrderDTO toDTO(Order entity) {
		OrderDTO dto = new OrderDTO();
		dto.setId(entity.getId());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setStatus(entity.getStatus());
		dto.setUser_id(entity.getUser().getId());
		return dto;
	}
	
	public Order toEntity(OrderDTO dto) {
		Order entity = new Order();
		entity.setStatus(dto.getStatus());
		return entity;
	}
}
