package com.springboot.kidgarden.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class LeQuocThang_04_Category {
	//Auto generate ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryid;
	
	private String categoryname;
	
	private String categorydescription;
	
	@OneToMany(mappedBy = "category")
	private Set<LeQuocThang_04_Article>articles;
	
}
