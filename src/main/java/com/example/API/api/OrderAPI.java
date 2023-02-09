package com.example.API.api;

import java.util.List;

import javax.transaction.Transactional;

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

import com.example.API.dto.OrderDTO;
import com.example.API.service.DetailOrderService;
import com.example.API.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/api/order")
public class OrderAPI {

	@Autowired
	private OrderService orderSevice;
	@Autowired
	private DetailOrderService detailOrderService;

	@PostMapping(value = "")
	public OrderDTO createOrder(@RequestBody OrderDTO order) {
		return orderSevice.save(order);
	}
	
	@GetMapping(value = "/user/{id}")
	public List<OrderDTO> getByUser(@PathVariable("id") long userID){
		return orderSevice.findAllByUser(userID);
	}
	
	@GetMapping(value = "/{id}")
	public OrderDTO getByID(@PathVariable("id") long id){
		return orderSevice.findOneById(id);
	}
	
	@PutMapping(value="/{id}")
	public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO, @PathVariable("id") long id) {
		return orderSevice.updateStatus(id, orderDTO);
	}
	
	@PutMapping(value="/cancel/{id}")
	@Transactional
	public boolean cancelOrder(@PathVariable("id") long id) {
		orderSevice.cancelOrder(id);
		detailOrderService.restoreQuantity(id);
		return true;
	}
	
}
