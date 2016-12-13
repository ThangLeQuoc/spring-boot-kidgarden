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
		//return categoryRepository.getCategories();
	}
	
	// create new category
	public void createCategory(Category category){
		categoryRepository.saveAndFlush(category);
	}
	
	public boolean categoryNameIsExist(String categoryShortName){
		Long category_id = categoryRepository.getIdByName(categoryShortName);
		if(category_id == null)
			return false;
		else{
			if(categoryRepository.exists(category_id))
				return true;
			return false;
		}
	
	}
	
	public boolean categoryIdIsExist(Long category_id){
		if(categoryRepository.exists(category_id))
			return true;
		return false;
	}
	
	

	//modify
	public void modifyCatagory(Category category){
		categoryRepository.updateCategory(category.getCategoryname(), category.getCategorydescription(), category.getCategoryshortname(), category.getCategory_id());
	}
	
	//remove
	
	public void removeCategory(Category category){
		categoryRepository.delete(category);
	}
	
	
	public Long getIdByName(String shortCategoryName){
		return categoryRepository.getIdByName(shortCategoryName);
	}
	
	public Category getCategory(Long categoryId){
		return categoryRepository.findOne(categoryId);
	}
}
