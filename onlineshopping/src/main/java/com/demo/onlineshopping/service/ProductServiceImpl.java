package com.demo.onlineshopping.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.onlineshopping.entity.Product;
import com.demo.onlineshopping.exceptions.RecordNotFoundException;
import com.demo.onlineshopping.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;
	
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProducts(String searchName) throws RecordNotFoundException{
		// TODO Auto-generated method stub
		List<Product> productList = productRepo.findByProductNameContainingIgnoreCase(searchName);
		if(Objects.isNull(productList)||productList.size()==0) {
			throw new RecordNotFoundException("No matching products found like :"+searchName);
		}
		return productList;
	}

	@Override
	public int saveProduct(Product product) {
		// TODO Auto-generated method stub
		Product productSaved = productRepo.save(product);
		return productSaved.getProductId();
	}

}
