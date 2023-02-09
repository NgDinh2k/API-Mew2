package com.example.API.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
//	private List<Product> products = new ArrayList<>();
}
