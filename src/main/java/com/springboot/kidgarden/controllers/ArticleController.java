package com.springboot.kidgarden.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.kidgarden.models.*;
import com.springboot.kidgarden.repository.*;
import com.springboot.kidgarden.services.*;

@RestController
public class ArticleController {

	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CategoryService categoryService; 
		
	@Autowired
	private ArticleDAO articleRepo;
	
	@RequestMapping(value="{category}/articles", method = RequestMethod.GET)
	public List<Article> getArticles(@PathVariable("category") String category){
		
		if(category.equals("all")){
			//return articleService.getAllArticles();
			return articleRepo.findAll();
		}
		else
		{
			Long categoryId = categoryService.getIdByName(category);
			return articleService.getArticlesByCategoryId(categoryId);
		}
	}
}
