package com.springboot.kidgarden.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kidgarden.models.Category;
import com.springboot.kidgarden.services.AccentRemover;
import com.springboot.kidgarden.services.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="administrator/category/create", method = RequestMethod.POST)
	public String createCategory(@RequestParam("categoryname") String categoryName,
											  @RequestParam("categorydescription") String categoryDescription){
		AccentRemover remover = new AccentRemover();
		remover.setString(categoryName);
		String shortname = remover.getCovertedString();
		
		if(categoryService.categoryNameIsExist(shortname)){
			return "Category Is Exist !";
		}
		else{
			Category category = new Category();
			category.setCategoryname(categoryName);
			category.setCategorydescription(categoryDescription);
			category.setCategoryshortname(shortname);
			System.out.println(categoryName+"-"+categoryDescription+"-"+shortname);
			categoryService.createCategory(category);
			return "Category Created !";
		}
	}
	
	@RequestMapping(value="administrator/category/modify", method = RequestMethod.PUT)
	public String modifyCategory(@RequestParam("categoryname") String categoryName,
												@RequestParam("categorydescription") String categoryDescription,
												@RequestParam("category_id") String category_id){
		if(categoryService.categoryIdIsExist(Long.valueOf(category_id))){
			AccentRemover remover = new AccentRemover();
			remover.setString(categoryName);
			String shortname = remover.getCovertedString();
			
			// category exist, begin modify
			Category category = new Category();
			
			category.setCategory_id(Long.valueOf(category_id));
			category.setCategoryname(categoryName);
			category.setCategorydescription(categoryDescription);
			category.setCategoryshortname(shortname);
			
			categoryService.modifyCatagory(category);
			
			return "Category Modified !";
		}
		else{
			return "Category not found";
		}
	}
	
	@RequestMapping(value="administrator/category/remove", method = RequestMethod.POST)
	public String removeCategory(@RequestParam("categoryname") String categoryName,
												 @RequestParam("categorydescription") String categoryDescription,
												 @RequestParam("category_id") String category_id){
		if(categoryService.categoryIdIsExist(Long.valueOf(category_id))){
			AccentRemover remover = new AccentRemover();
			remover.setString(categoryName);
			String shortname = remover.getCovertedString();
			
			// category exist, remove it
			Category category = new Category();
			
			category.setCategory_id(Long.valueOf(category_id));
			category.setCategoryname(categoryName);
			category.setCategorydescription(categoryDescription);
			category.setCategoryshortname(shortname);
			
			categoryService.removeCategory(category);
			return "Category Removed !";
		}
		else{
			return "Category not found";
		}
	}
	
}
