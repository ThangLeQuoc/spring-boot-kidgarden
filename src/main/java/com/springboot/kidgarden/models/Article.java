/***
 *  Created on : 02/12/2016
 *  Author: Le Quoc Thang
 *  Description: Lop Article la lop anh xa mot bai dang tren dien dan
 *  
 *  ***/

package com.springboot.kidgarden.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="articles")
public class Article {

	//Auto generate ID
	@Column(name="article_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long article_id;   // articleid

	private String header; // 
	private String headerdescription;
	private String headerimage;
	private String location;
	private String date;
	private String note;
	private String dayofpublish;
	@Lob
	private String content;
	private String source;
	
	// One Article -> One Category || One category -> Many Articles
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="category", referencedColumnName="category_id")
	private Category category;
	
	// One Article -> One author || One author -> Many Articles
	
	@ManyToOne(optional = false, fetch=FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="editor", referencedColumnName="username")
	private Useraccount editor;

	
	
	
	public long getArticle_id() {
		return article_id;
	}

	public void setArticle_id(long article_id) {
		this.article_id = article_id;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getHeaderDescription() {
		return headerdescription;
	}

	public void setHeaderDescription(String headerDescription) {
		this.headerdescription = headerDescription;
	}

	public String getHeaderimage() {
		return headerimage;
	}

	public void setHeaderimage(String headerimage) {
		this.headerimage = headerimage;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDayofpublish() {
		return dayofpublish;
	}

	public void setDayofpublish(String dayofpublish) {
		this.dayofpublish = dayofpublish;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Useraccount getEditor() {
		return editor;
	}

	public void setEditor(Useraccount editor) {
		this.editor = editor;
	}
}
