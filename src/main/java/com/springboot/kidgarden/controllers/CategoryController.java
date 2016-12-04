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
		System.out.print("Receive !");
		Category category = new Category();
		category.setCategoryname(categoryName);
		category.setCategorydescription(categoryDescription);
		category.setCategoryshortname(shortname);
		
		categoryService.createCategory(category);
		return "Category Created !";
	}
	
}
