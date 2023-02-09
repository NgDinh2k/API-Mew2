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
import org.springframework.web.bind.annotation.RestController;

import com.example.API.dto.UserDTO;
import com.example.API.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserAPI {
	@Autowired
	private UserService userService;

	@GetMapping(value = "")
	public List<UserDTO> getAll() {
		return userService.findAll();
	}

	@PostMapping(value = "")
	public UserDTO createUser(@RequestBody UserDTO user) {
		return userService.save(user);
	}

	@PutMapping(value = "/{id}")
	public UserDTO updateCategory(@RequestBody UserDTO user, @PathVariable("id") long id) {
		user.setId(id);
		return userService.save(user);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		userService.delete(id);
	}

}
