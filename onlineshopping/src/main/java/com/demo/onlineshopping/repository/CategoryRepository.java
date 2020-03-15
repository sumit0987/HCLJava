package com.demo.onlineshopping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.onlineshopping.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
