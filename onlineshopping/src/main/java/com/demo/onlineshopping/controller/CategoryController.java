package com.demo.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.onlineshopping.entity.Category;
import com.demo.onlineshopping.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService catService;
	
	@PostMapping("/category/{categoryName}")
	public ResponseEntity<?> saveCategory(@PathVariable String categoryName){
		int id=0;
		if(categoryName!=null) {
			id = catService.saveCategory(categoryName);
		}
		 
	     if(id>0) {
	          return new ResponseEntity<Category>(HttpStatus.OK);
	     }
	        throw new RuntimeException("Category Save ERROR");
	}
}
