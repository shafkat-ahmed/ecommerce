package com.boot.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
	@Query("SELECT p from Product p where p.type =:type ") 
	List<Product> getProductByType(@Param("type") String type);
	
   
	
}
