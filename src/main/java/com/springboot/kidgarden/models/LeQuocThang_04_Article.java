/***
 *  Created on : 02/12/2016
 *  Author: Le Quoc Thang
 *  Description: Lop Article la lop anh xa mot bai dang tren dien dan
 *  
 *  ***/

package com.springboot.kidgarden.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="articles")
public class LeQuocThang_04_Article {
	//Auto generate ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int articleId;   // articleid
	
	private String header; // 
	private String headerDescription;
	private String headerimage;
	private String location;
	private String date;
	private String note;
	private String dayofpublish;
	private String content;
	private String source;
	
	// One Article -> One Category || One category -> Many Articles
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="article_cat")
	private LeQuocThang_04_Category category;
	
	// One Article -> One author || One author -> Many Articles
	
	@ManyToOne(optional = false, fetch=FetchType.EAGER)
	@JoinColumn(name="article_author")
	private LeQuocThang_04_Useraccount editor;
		
}
