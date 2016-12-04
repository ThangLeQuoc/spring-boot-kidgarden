package com.springboot.kidgarden.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.kidgarden.models.Article;
import com.springboot.kidgarden.models.Category;

public interface CategoryDAO extends JpaRepository<Category, Long> {
	
	
	
	//retrieve id of category by short name
	@Query("SELECT category.category_id FROM Category category WHERE category.categoryshortname = ?1")
	Long getIdByName(String categoryShortName);
	
}
