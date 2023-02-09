package com.example.API.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User extends BaseEntity {
	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String passWord;

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "status")
	private String status;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", 
			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
	private Set<Role> roles = new HashSet<>();
	
//	@OneToMany(mappedBy = "user")
//	private List<Order> orders = new ArrayList<>();
//	
//	@OneToMany(mappedBy = "user")
//	private List<Cart> carts = new ArrayList<>();
}
