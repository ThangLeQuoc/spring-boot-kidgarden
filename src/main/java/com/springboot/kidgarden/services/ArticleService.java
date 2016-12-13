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
	
	// query all Articles
	public List<Article> getAllArticles(){
		return articleRepository.findAll();
	}
	
	// query Articles by Selected Category
	public List<Article> getArticlesByCategoryId(Long categoryId){
		return articleRepository.findByCategory(categoryId);	
	}
	
	// query an Article for detail
	public Article getArticleDetail(String article_id){
		Long article_id_temp = Long.valueOf(article_id); 
		return articleRepository.findOne(article_id_temp);
	}
	
	
	// create new Articles
	public void postArticle(Article article){
		articleRepository.saveAndFlush(article);
	}
	
	//
}
