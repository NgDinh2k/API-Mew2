package com.example.API.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.API.dto.CartDTO;
import com.example.API.service.CartService;

@CrossOrigin
@RestController
@RequestMapping("/api/cart")
public class CartAPI {
	
	@Autowired
	private CartService cartService;

	@GetMapping(value = "/{id}")
	public List<CartDTO> getByID(@PathVariable("id") long id) {
		return cartService.getCartByUserId(id);
	}

	@PostMapping(value = "")
	public CartDTO addToCart(@RequestBody CartDTO cart) {
		return cartService.save(cart);
	}

	@PutMapping(value = "")
	public CartDTO editItem(@RequestBody CartDTO cart) {
		return cartService.save(cart);
	}

	@DeleteMapping(value = "")
	public boolean deleteItem(@RequestParam Long productId, @RequestParam Long userId) {
		return cartService.deleteItem(productId, userId);
	}

}
