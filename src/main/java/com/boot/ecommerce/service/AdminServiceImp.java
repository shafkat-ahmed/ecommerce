package com.boot.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.boot.ecommerce.entity.Product;
import com.boot.ecommerce.entity.User;
import com.boot.ecommerce.repository.ProductRepository;
import com.boot.ecommerce.repository.SaleRepository;
import com.boot.ecommerce.repository.UserRepository;

@Service
public class AdminServiceImp implements AdminService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SaleRepository saleRepository;
	@Autowired
	private UserRepository userRepository;
	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		
		productRepository.save(product);
		
	}
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}
	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productRepository.getById(id);
	}
	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		
	}
	@Override
	public Page<Product> findPaginated(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return this.productRepository.findAll(pageable);
		
	}
	@Override
	public int getUserId(String name) {
		// TODO Auto-generated method stub
		return userRepository.getUserId(name);
	}
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.getById(id);
	}
	@Override
	public List<Integer> getListSlotId() {
		// TODO Auto-generated method stub
		return saleRepository.getListSlotId();
	}
	

}
