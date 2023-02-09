package com.example.API.service;

import java.util.List;

import com.example.API.dto.UserDTO;


public interface UserService {
	public List<UserDTO> findAll();
	
	public UserDTO findOneById(Long id);
	
	public UserDTO save(UserDTO userDTO);
	
	public boolean delete(Long id);
}
