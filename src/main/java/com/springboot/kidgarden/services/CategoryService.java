package com.springboot.kidgarden.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.kidgarden.models.Category;
import com.springboot.kidgarden.repository.CategoryDAO;

@Service
public class CategoryService {
	@Autowired
	private CategoryDAO categoryRepository;
	
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	// create new category
	public void createCategory(Category category){
		categoryRepository.saveAndFlush(category);
	}
	
	
	
	
	
	
	
	
	public Long getIdByName(String shortCategoryName){
		return categoryRepository.getIdByName(shortCategoryName);
	}
	
	public Category getCategory(Long categoryId){
		return categoryRepository.findOne(categoryId);
	}
}
