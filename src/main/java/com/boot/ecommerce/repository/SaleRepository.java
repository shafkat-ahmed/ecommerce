package com.boot.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.ecommerce.entity.Sale;
import com.boot.ecommerce.entity.User;





public interface SaleRepository extends JpaRepository<Sale, Integer>
{

	@Query("SELECT s from Sale s where s.user =:user ") 
	List<Sale> getUserSales(@Param("user") User user);
    
	@Query("SELECT id from Sale s") 
	List<Integer> getListSlotId();
    	
	
	
}
