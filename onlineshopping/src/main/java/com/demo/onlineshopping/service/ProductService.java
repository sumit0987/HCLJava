package com.demo.onlineshopping.service;

import java.util.List;

import com.demo.onlineshopping.entity.Product;
import com.demo.onlineshopping.exceptions.RecordNotFoundException;

public interface ProductService {
	public List<Product> getProducts();
	public List<Product> searchProducts(String serachName) throws RecordNotFoundException;
	public int saveProduct(Product product);
}
