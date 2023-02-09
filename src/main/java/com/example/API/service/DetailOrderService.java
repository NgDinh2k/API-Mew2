package com.example.API.service;

import java.util.List;
import com.example.API.dto.DetailOrderDTO;

public interface DetailOrderService {
	
	public List<DetailOrderDTO> getDetailOrder(Long orderID);
	
	public List<DetailOrderDTO> save(Long orderID);
	
//	public boolean deleteItem(DetailOrderDTO detailOrderDTO);
	
	public boolean restoreQuantity(Long orderID);
	
//	public DetailOrderDTO update(Long orderID, List<DetailOrderDTO> listDetail);
}
