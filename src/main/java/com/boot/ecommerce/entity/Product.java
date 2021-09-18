package com.boot.ecommerce.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    @Column(name="name")
	    private String name;
	    @Column(name="price")
	    private int price;
	    @Column(name="profit")
	    private int profit;
	    @Column(name="type")
	    private String type;
	    
	   @OneToMany(mappedBy="product",cascade= {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE})
	    private List<Sale> sales; 
	    
		
		public List<Sale> getSales() {
			return sales;
		}
		public void setSales(List<Sale> sales) {
			this.sales = sales;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getProfit() {
			return profit;
		}
		public void setProfit(int profit) {
			this.profit = profit;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
	    
	    

}
