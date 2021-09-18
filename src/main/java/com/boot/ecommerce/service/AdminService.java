package com.boot.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.boot.ecommerce.entity.Product;
import com.boot.ecommerce.entity.User;

public interface AdminService {

	void saveProduct(Product product);

	List<Product> getAllProduct();

	Product getProductById(int id);

	void deleteProduct(int id);

	Page<Product> findPaginated(int pageNo, int pageSize);

	int getUserId(String name);

	User getUserById(int id);

	List<Integer> getListSlotId();


	

}
