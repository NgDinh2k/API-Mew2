package com.example.API.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.dto.DetailOrderDTO;
import com.example.API.entity.Cart;
import com.example.API.entity.DetailOrder;
import com.example.API.entity.Order;
import com.example.API.entity.Product;
import com.example.API.entity.User;
import com.example.API.entity.entityPK.DetailOrderPK;
import com.example.API.repository.CartRepository;
import com.example.API.repository.DetailOrderRepository;
import com.example.API.repository.OrderRepository;
import com.example.API.repository.ProductRepository;
import com.example.API.service.DetailOrderService;

@Service
public class DetailOrderImpl implements DetailOrderService {

	@Autowired
	private DetailOrderRepository detailOrderRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CartRepository cartRepository;


	@Override
	public List<DetailOrderDTO> getDetailOrder(Long orderID) {
		Order order = orderRepository.findById(orderID).orElseThrow(() -> new IllegalStateException("Not found Order"));
		List<DetailOrder> list = detailOrderRepository.findByOrder(order);
		List<DetailOrderDTO> listDetailOrder = new ArrayList<>();
		for (DetailOrder detail : list) {
			DetailOrderDTO dto = DetailOrderDTO.toDTO(detail);
			listDetailOrder.add(dto);
		}
		return listDetailOrder;
	}

	@Override
	@Transactional
	public List<DetailOrderDTO> save(Long orderID) {
		Order order = orderRepository.findById(orderID).orElseThrow(() -> new IllegalStateException("Not found Order"));
		User user = order.getUser();
		List<Cart> listCart = cartRepository.findByUser(user);
		List<DetailOrderDTO> listDetailDTO = new ArrayList<>();
		for (Cart detailCart : listCart) {
			Long productID = detailCart.getProduct().getId();
			Product product = productRepository.findById(productID)
					.orElseThrow(() -> new IllegalStateException("Not found Product"));
			DetailOrderPK id = new DetailOrderPK(orderID, productID);
			DetailOrder detailOrder = new DetailOrder();
			detailOrder.setId(id);
			detailOrder.setOrder(order);
			detailOrder.setProduct(product);
			detailOrder.setPrice(detailCart.getPrice());
			detailOrder.setQuantity(detailCart.getQuantity());
			detailOrderRepository.save(detailOrder);
			
			//Change quantity product
			product.setQuantity(product.getQuantity() - detailCart.getQuantity());
			productRepository.save(product);
			listDetailDTO.add(DetailOrderDTO.toDTO(detailOrder));
		}
		//Delete cart by user
		cartRepository.deleteAllByUser(user);
		return listDetailDTO;
	}

//	@Override
//	public boolean deleteItem(DetailOrderDTO detailOrderDTO) {
//		DetailOrderPK id = new DetailOrderPK(detailOrderDTO.getOrderID(), detailOrderDTO.getProductId());
//		DetailOrder detail = detailOrderRepository.findById(id)
//				.orElseThrow(() -> new IllegalStateException("Not found Detail Order"));
//		detailOrderRepository.delete(detail);
//		return true;
//	}

	@Override
	public boolean restoreQuantity(Long orderID) {
		Order order = orderRepository.findById(orderID).orElseThrow(() -> new IllegalStateException("Not found Order"));
		List<DetailOrder> detailOrder = detailOrderRepository.findByOrder(order);
		for (DetailOrder detail : detailOrder) {
			Product product = productRepository.findById(detail.getProduct().getId())
					.orElseThrow(() -> new IllegalStateException("Not found Product"));
			product.setQuantity(product.getQuantity() + detail.getQuantity());
			productRepository.save(product);
		}
		return true;
	}

}
