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
public class CartPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long product_id;
	private Long user_id;
}
