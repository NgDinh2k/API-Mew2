package com.example.API.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.dto.OrderDTO;
import com.example.API.entity.Order;
import com.example.API.entity.User;
import com.example.API.repository.OrderRepository;
import com.example.API.repository.UserRepository;
import com.example.API.service.OrderService;

@Service
public class OrderImpl implements OrderService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<OrderDTO> findAllByUser(Long userID) {
		User user = userRepository.findById(userID).orElseThrow(() -> new IllegalStateException("Not found User"));
		List<Order> list = orderRepository.findByUser(user);
		List<OrderDTO> listOrder = new ArrayList<>();
		for (Order order : list) {
			OrderDTO dto = OrderDTO.toDTO(order);
			listOrder.add(dto);
		}
		return listOrder;

	}

	@Override
	public OrderDTO findOneById(Long id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalStateException("Not found Order"));
		return OrderDTO.toDTO(order);
	}

	@Override
	public OrderDTO save(OrderDTO orderDTO) {
		User user = userRepository.findById(orderDTO.getUser_id())
				.orElseThrow(() -> new IllegalStateException("Not found User"));
		Order order = new Order();
		order.setUser(user);
		order.setCreatedDate(new Date());
		order.setStatus("Pending");
		Order saveOrder = orderRepository.save(order);
		orderDTO = OrderDTO.toDTO(saveOrder);
		return orderDTO;
	}

	@Override
	public OrderDTO cancelOrder(Long id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalStateException("Not found Order"));
		order.setStatus("Cancel");
		orderRepository.save(order);		
		return OrderDTO.toDTO(order);
	}

	@Override
	public OrderDTO updateStatus(Long id, OrderDTO orderDTO) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalStateException("Not found Order"));
		order.setStatus(orderDTO.getStatus());
		order.setModifiedDate(new Date());
		orderRepository.save(order);
		return OrderDTO.toDTO(order);
	}

}
