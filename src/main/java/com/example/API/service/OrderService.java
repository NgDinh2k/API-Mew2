package com.example.API.service;

import java.util.List;

import com.example.API.dto.OrderDTO;
import com.example.API.entity.Order;



public interface OrderService {

	public List<OrderDTO> findAllByUser(Long userID);
	
	public OrderDTO findOneById(Long id);
	
	public OrderDTO save(OrderDTO orderDTO);
	
	public OrderDTO cancelOrder(Long id);
	
	public OrderDTO updateStatus(Long id, OrderDTO orderDTO);
	
}
