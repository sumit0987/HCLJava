package com.demo.onlineshopping.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.onlineshopping.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	public List<Product> findByProductNameContainingIgnoreCase(String productName);
	
}
