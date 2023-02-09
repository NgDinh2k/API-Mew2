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

import com.example.API.entity.entityPK.DetailOrderPK;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detailorder")
public class DetailOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private DetailOrderPK id = new DetailOrderPK();

	@ManyToOne
	@MapsId("order_id")
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@MapsId("product_id")
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "quantity", nullable = false)
	@ColumnDefault(value = "0")
	private int quantity;

	@Column(name = "price", nullable = false)
	@ColumnDefault(value = "0")
	private Double price;

}
