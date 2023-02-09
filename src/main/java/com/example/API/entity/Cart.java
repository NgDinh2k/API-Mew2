package com.example.API.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.example.API.entity.entityPK.CartPK;

import lombok.Data;

@Entity
@Table(name = "cart")
@Data
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private CartPK id = new CartPK();

	@ManyToOne
	@MapsId("product_id")
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "quantity", nullable = false)
	@ColumnDefault(value = "0")
	private int quantity;

	@Column(name = "price", nullable = false)
	@ColumnDefault(value = "0")
	private Double price;
}
