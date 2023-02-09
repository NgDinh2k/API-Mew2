package com.example.API.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API.dto.DetailOrderDTO;
import com.example.API.service.DetailOrderService;

@CrossOrigin
@RestController
@RequestMapping("/api/detailorder")
public class DetailOrderAPI {
	@Autowired
	private DetailOrderService detailOrderService;
	
	@GetMapping(value="/{id}")
	public List<DetailOrderDTO> getDetailOrder(@PathVariable("id") long id){
		return detailOrderService.getDetailOrder(id);
	}
	
	@PostMapping(value = "/{id}")
	public List<DetailOrderDTO> createDetail(@PathVariable("id") long id) {
		return detailOrderService.save(id);
	}

}
