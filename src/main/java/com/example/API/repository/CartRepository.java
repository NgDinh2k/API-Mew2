package com.example.API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.API.entity.Cart;
import com.example.API.entity.User;
import com.example.API.entity.entityPK.CartPK;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartPK> {
	
	List<Cart> findByUser(User user);

	void deleteAllByUser(User user);
}
