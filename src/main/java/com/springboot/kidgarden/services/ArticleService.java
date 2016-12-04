package com.springboot.kidgarden.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.kidgarden.repository.ArticleDAO;
import com.springboot.kidgarden.models.*;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleDAO articleRepository;
	
	// query Articles
	public List<Article> getAllArticles(){
		return articleRepository.findAll();
	}
	
	public List<Article> getArticlesByCategoryId(Long categoryId){
		return articleRepository.findByCategory(categoryId);	
	}
	
	
	// create new Articles
	public void postArticle(Article article){
		articleRepository.saveAndFlush(article);
	}
	
	//
}
