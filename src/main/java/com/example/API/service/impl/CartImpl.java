package com.example.API.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.dto.CartDTO;
import com.example.API.entity.Cart;
import com.example.API.entity.Product;
import com.example.API.entity.User;
import com.example.API.entity.entityPK.CartPK;
import com.example.API.repository.CartRepository;
import com.example.API.repository.ProductRepository;
import com.example.API.repository.UserRepository;
import com.example.API.service.CartService;

@Service
public class CartImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<CartDTO> getCartByUserId(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("Not found User"));
		List<Cart> list = cartRepository.findByUser(user);
		List<CartDTO> listCartDTO = new ArrayList<>();
		for (Cart cart : list) {
			CartDTO dto = CartDTO.toDTO(cart);
			listCartDTO.add(dto);
		}
		return listCartDTO;
	}

	@Override
	public CartDTO save(CartDTO cart) {		
		CartPK cartPK = new CartPK(cart.getProductId(),cart.getUserId());
		
		Cart oldCart = cartRepository.findById(cartPK).orElse(null);
		if(oldCart!=null) {
			oldCart.setQuantity(cart.getQuantity());
			return CartDTO.toDTO(cartRepository.save(oldCart));
		}
		Cart newCart = CartDTO.toEntity(cart);
		Product product = productRepository.findById(cart.getProductId())
				.orElseThrow(()-> new IllegalStateException("Not Found Product"));
		User user = userRepository.findById(cart.getUserId()).orElse(null);
		newCart.setProduct(product);
		newCart.setUser(user);
		newCart.setPrice(product.getPrice());
		return CartDTO.toDTO(cartRepository.save(newCart));
	}

	@Override
	public boolean deleteItem(Long productId, Long userId) {
		CartPK cartPK = new CartPK(productId, userId);
		Cart cart = cartRepository.findById(cartPK).orElseThrow(()-> new IllegalStateException("Not Found Cart Item"));
		cartRepository.delete(cart);
		return true;
	}

	@Override
	public void deleteAfterTransaction(User user) {
		cartRepository.deleteAllByUser(user);
	}
	
}
