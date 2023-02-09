package com.example.API.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.example.API.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends AbstractDTO<UserDTO> {

	private String userName;
	private String passWord;
	private String fullName;
	private String status;
	private Set<String> roles;

	public static UserDTO toDTO(User entity) {
		UserDTO dto = new UserDTO();
		dto.setId(entity.getId());
		dto.setUserName(entity.getUserName());
		dto.setPassWord(entity.getPassWord());
		dto.setFullName(entity.getFullName());
		dto.setStatus(entity.getStatus());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		
		Set<String> roles = new HashSet<>();
		if(Objects.nonNull(entity.getRoles())) {
			entity.getRoles().forEach(r -> {
				roles.add(r.getName());
			});
		}

		dto.setRoles(roles);
		return dto;
	}

	public static User toEntity(UserDTO dto) {
		User entity = new User();
		entity.setUserName(dto.getUserName());
		entity.setPassWord(dto.getPassWord());
		entity.setFullName(dto.getFullName());
		entity.setStatus(dto.getStatus());
		return entity;
	}

	public static User toEntity(UserDTO dto, User entity) {
		entity.setUserName(dto.getUserName());
		entity.setPassWord(dto.getPassWord());
		entity.setFullName(dto.getFullName());
		entity.setStatus(dto.getStatus());
		return entity;
	}
}
