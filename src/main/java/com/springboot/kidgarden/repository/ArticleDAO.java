package com.springboot.kidgarden.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.kidgarden.models.Article;
import com.springboot.kidgarden.models.Category;
import com.springboot.kidgarden.models.Useraccount;

public interface ArticleDAO extends JpaRepository<Article, Long> {	
	
	// retrieve all article of a selected category
	@Query("SELECT article FROM Article article WHERE article.category.category_id = ?1")
	List<Article> findByCategory(Long category_id);
	
	// update an article
	@Transactional
	@Modifying
	@Query("UPDATE Article article SET article.header = :header, article.headerdescription = :headerdescription,  article.headerimage = :headerimage,"
			+ " article.location = :location, article.date = :date, article.note=:note, article.dayofpublish = :dayofpublish, article.content = :content, article.source = :source "
			+ " WHERE article.article_id = :article_id")
	int updateArticle(@Param("header") String header,
							 @Param("headerdescription") String headerdescription,
							 @Param("headerimage") String headerimage,
							 @Param("location") String location,
							 @Param("date") String date,
							 @Param("note") String note,
							 @Param("dayofpublish") String dayofpublish,
							 @Param("content") String content,
							 @Param("source") String source,
							 @Param("article_id") String article_id);
	
	//list articles of selected category
	List<Article> findAllByCategory(Category category);
	
}
