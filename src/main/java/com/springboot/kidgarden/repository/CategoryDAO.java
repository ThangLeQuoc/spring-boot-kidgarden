package com.springboot.kidgarden.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.kidgarden.models.Article;
import com.springboot.kidgarden.models.Category;

public interface CategoryDAO extends JpaRepository<Category, Long> {
	
	
	
	//retrieve id of category by short name
	@Query("SELECT category.category_id FROM Category category WHERE category.categoryshortname = ?1")
	Long getIdByName(String categoryShortName);
	
	
	// Update category
	@Transactional
	@Modifying
	@Query("UPDATE Category category SET category.categoryname = :categoryname, category.categorydescription = :categorydescription, category.categoryshortname = :categoryshortname WHERE category.category_id = :category_id")
	int updateCategory(@Param("categoryname") String categoryName,
								  @Param("categorydescription") String categoryDescription,
								  @Param("categoryshortname") String categoryShortName,
								  @Param("category_id") Long category_id);
								  
}
