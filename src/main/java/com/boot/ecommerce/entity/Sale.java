package com.boot.ecommerce.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "sale")
public class Sale {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="product_id")
	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
		

}
