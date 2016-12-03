package com.springboot.kidgarden.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.kidgarden.models.Article;

public interface ArticleDAO extends JpaRepository<Article, Long> {	
	
	// retrieve all article of a category
	@Query("SELECT article FROM Article article WHERE article.category.category_id = ?")
	List<Article> findByCategory(Long category_id);
	
}
