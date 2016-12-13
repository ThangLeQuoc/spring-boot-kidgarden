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
	private UserService userService;

	@Autowired
	private ArticleDAO articleRepo;

	// get articles of selected category
	@RequestMapping(value = "{category}/articles", method = RequestMethod.GET)
	public List<Article> getArticles(@PathVariable("category") String category) {
		if (category.equals("all")) {
			return articleService.getAllArticles();
		} else {
			
			
			Long categoryId = categoryService.getIdByName(category);
			Category selectedCategory = categoryService.getCategory(categoryId);
			return articleRepo.findAllByCategory(selectedCategory);
			//return articleService.getArticlesByCategoryId(categoryId);
		}
	}
	
	//get a specific article
	@RequestMapping(value="{category}/articles/{id}", method = RequestMethod.GET)
	public Article getArticleDetail(@PathVariable("id") String article_id){
		return null;
	}

	// post articles
	@RequestMapping(value = "administrator/{user}/post/article", method = RequestMethod.POST)
	public String postArticle(@RequestParam("header") String header,
			@RequestParam("headerdescription") String headerDescription,
			@RequestParam("headerimage") String headerImage, @RequestParam("location") String location,
			@RequestParam("date") String date, @RequestParam("note") String note,
			@RequestParam("dayofpublish") String dayOfPublish, @RequestParam("content") String content,
			@RequestParam("source") String source, @RequestParam("category_id") String categoryId,
			@PathVariable("user") String username) {

		// create article object

		Article article = new Article();
		article.setHeader(header);
		article.setHeaderdescription(headerDescription);
		article.setHeaderimage(headerImage);
		article.setLocation(location);
		article.setDate(date);
		article.setNote(note);
		article.setDayofpublish(dayOfPublish);
		article.setContent(content);
		article.setSource(source);
		article.setCategory(categoryService.getCategory(Long.parseLong(categoryId)));
		article.setEditor(userService.getUser(username));

		articleService.postArticle(article);
		return "Article Created !";
	}

	// update article
	@RequestMapping(value = "administrator/{user}/modify/article", method = RequestMethod.PUT)
	public String modifyArticle(
			@RequestParam("id") String article_id,
			@RequestParam("header") String header,
			@RequestParam("headerdescription") String headerDescription,
			@RequestParam("headerimage") String headerImage, @RequestParam("location") String location,
			@RequestParam("date") String date, @RequestParam("note") String note,
			@RequestParam("dayofpublish") String dayOfPublish, @RequestParam("content") String content,
			@RequestParam("source") String source, 
			@RequestParam("category_id") String categoryId,
			@PathVariable("user") String username) {

		// create article object
		/*
		Article article = new Article();
		article.setHeader(header);
		article.setHeaderDescription(headerDescription);
		article.setHeaderimage(headerImage);
		article.setLocation(location);
		article.setDate(date);
		article.setNote(note);
		article.setDayofpublish(dayOfPublish);
		article.setContent(content);
		article.setSource(source);
		article.setCategory(categoryService.getCategory(Long.parseLong(categoryId)));
		article.setEditor(userService.getUser(username));
		*/
		System.out.print(article_id);
		

		//articleService.postArticle(article);
		return "Article Created !";
	}
}
