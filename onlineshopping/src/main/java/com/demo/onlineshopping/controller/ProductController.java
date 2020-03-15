package com.demo.onlineshopping.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.onlineshopping.entity.Product;
import com.demo.onlineshopping.exceptions.RecordNotFoundException;
import com.demo.onlineshopping.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		return null;
	}
	
	@PostMapping("/products")
	public ResponseEntity<?> saveProduct(@RequestBody Product product){
		int id=0;
		if(product!=null) {
			id = productService.saveProduct(product);
		}
		 
	     if(id>0) {
	          return new ResponseEntity<Product>(product,HttpStatus.OK);
	     }
	        throw new RuntimeException("Product Save ERROR");
	}
	
	@GetMapping("/products/{productName}")
	public ResponseEntity<List<Product>> searchProducts(@PathVariable String productName){
		List<Product> productList = productService.searchProducts(productName);
		if(Objects.isNull(productList)||productList.size()==0){
			throw new RecordNotFoundException("No matching products found like "+productName);
		}
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}
}
