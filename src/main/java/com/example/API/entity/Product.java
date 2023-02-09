package com.example.API.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "name")
	private String name;

	@Column(name = "image")
	private String image;

	@Column(name = "price")
	private double price;

	@Column(name = "quantity")
	private int quantity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
//	private List<DetailOrder> detailOrders = new ArrayList<>();

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
//	private List<Cart> carts = new ArrayList<>();

}
