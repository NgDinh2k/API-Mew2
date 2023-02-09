package com.example.API.entity.entityPK;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class DetailOrderPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long order_id;
	private Long product_id;
}
