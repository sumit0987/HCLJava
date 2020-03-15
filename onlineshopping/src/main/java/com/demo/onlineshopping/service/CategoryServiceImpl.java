package com.demo.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.onlineshopping.entity.Category;
import com.demo.onlineshopping.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepo;

	@Override
	public int saveCategory(String categoryName) {
		// TODO Auto-generated method stub
		Category cat = new Category();
		cat.setCategoryName(categoryName);
		Category category = categoryRepo.save(cat); 	
		return category.getCategoryId();
	}

}
