package com.example.API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.API.entity.Order;
import com.example.API.entity.User;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByUser(User user);
}
