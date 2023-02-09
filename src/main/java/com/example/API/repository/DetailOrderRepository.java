package com.example.API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.API.entity.DetailOrder;
import com.example.API.entity.Order;
import com.example.API.entity.User;
import com.example.API.entity.entityPK.DetailOrderPK;

public interface DetailOrderRepository extends JpaRepository<DetailOrder, DetailOrderPK>{
	
	List<DetailOrder> findByOrder(Order order);

}
