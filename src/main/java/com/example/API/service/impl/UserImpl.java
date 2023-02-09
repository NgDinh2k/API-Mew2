package com.example.API.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.dto.UserDTO;
import com.example.API.entity.Category;
import com.example.API.entity.Role;
import com.example.API.entity.User;
import com.example.API.repository.RoleRepository;
import com.example.API.repository.UserRepository;
import com.example.API.service.UserService;

@Service
public class UserImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> listUserDTO = new ArrayList<>();
		List<User> list = userRepository.findAll();
		for (User user : list) {
			UserDTO userDTO = UserDTO.toDTO(user);
			listUserDTO.add(userDTO);
		}
		return listUserDTO;
	}

	@Override
	public UserDTO findOneById(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Not found User"));		
		return UserDTO.toDTO(user);
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		User user = new User();
		if (userDTO.getId() != null) {
			User oldUser = userRepository.findById(userDTO.getId()).orElseThrow();
			user = UserDTO.toEntity(userDTO, oldUser);
			user.setModifiedDate(new Date());
		} else {
			user = UserDTO.toEntity(userDTO);
			user.setCreatedDate(new Date());
		}
		Set<String> strRoles = userDTO.getRoles();
		Set<Role> roles = new HashSet<>();
		if (userDTO.getRoles() == null) {
			Role userRole = roleRepository.findByName("ROLE_USER")
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				Role userRole = roleRepository.findByName(role)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
			});
		}
		user.setRoles(roles);
		User users = userRepository.save(user);
		return UserDTO.toDTO(users);
	}

	@Override
	public boolean delete(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Not found User"));
		userRepository.delete(user);
		return true;
	}

}
