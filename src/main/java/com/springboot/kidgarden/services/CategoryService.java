package com.springboot.kidgarden.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.kidgarden.repository.CategoryDAO;

@Service
public class CategoryService {
	@Autowired
	private CategoryDAO categoryRepository;
	
	public Long getIdByName(String shortCategoryName){
		return categoryRepository.getIdByName(shortCategoryName);
	
	}
}
