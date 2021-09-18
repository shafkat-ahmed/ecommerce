package com.boot.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.boot.ecommerce.entity.Product;
import com.boot.ecommerce.entity.Sale;
import com.boot.ecommerce.entity.User;

public interface UserService {

	int getUserId(String name);

	User getUserById(int id);

	List<Product> getProductByType(String type);

	Product getProductById(int id);

	void saveSale(Sale sale);

	List<Sale> getUserSales(User user);

	Page<Product> findPaginated(int pageNo, int pageSize);



	

}
