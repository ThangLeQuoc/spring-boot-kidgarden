package com.springboot.kidgarden.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="categories")
public class Category {
	//Auto generate ID
	@Column(name="category_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long category_id;
	
	@Column(name="categoryname", nullable=true)
	private String categoryname;
	
	@Column(name="categorydescription", nullable=true)
	private String categorydescription;
	
	@Column(name="categoryshortname", nullable=true)
	private String categoryshortname;
	
	
	@OneToMany(mappedBy = "category")
	@Column(nullable = true)
	@JsonManagedReference
	private Set<Article>articles;

	
	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategorydescription() {
		return categorydescription;
	}

	public void setCategorydescription(String categorydescription) {
		this.categorydescription = categorydescription;
	}

	public String getCategoryshortname() {
		return categoryshortname;
	}

	public void setCategoryshortname(String categoryshortname) {
		this.categoryshortname = categoryshortname;
	}
	
	
	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	
}
