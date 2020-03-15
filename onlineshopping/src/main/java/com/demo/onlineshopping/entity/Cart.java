package com.demo.onlineshopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@Column(name="cartid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
}
