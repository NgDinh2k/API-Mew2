package com.example.API.service;

import java.util.List;

import com.example.API.dto.CartDTO;
import com.example.API.entity.User;

public interface CartService {

	List<CartDTO> getCartByUserId(Long userId);

	CartDTO save(CartDTO cart);

	boolean deleteItem(Long productId, Long userId);

	void deleteAfterTransaction(User user);
}
