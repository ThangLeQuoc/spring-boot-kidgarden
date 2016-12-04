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
@Table(name="useraccount")
public class Useraccount {
	@Column(name="username")
	@Id
	private String username;
	
	@Column(name="name", nullable=true)
	private String name;
	
	@Column(name="password", nullable=true)
	private String password;
	
	@Column(name="facebookinfo", nullable=true)
	private String facebookinfo;
	
	@Column(name="googlegmailinfo", nullable=true)
	private String googlegmailinfo;
	
	@Column(name="twitterinfo", nullable=true)
	private String twitterinfo;
	
	@Column(name="phonenumber", nullable=true)
	private String phonenumber;
	
	@OneToMany(mappedBy = "editor")
	@Column(nullable = true)
	@JsonManagedReference
	private Set<Article>articles;
	
	
	
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFacebookinfo() {
		return facebookinfo;
	}

	public void setFacebookinfo(String facebookinfo) {
		this.facebookinfo = facebookinfo;
	}

	public String getGooglegmailinfo() {
		return googlegmailinfo;
	}

	public void setGooglegmailinfo(String googlegmailinfo) {
		this.googlegmailinfo = googlegmailinfo;
	}

	public String getTwitterinfo() {
		return twitterinfo;
	}

	public void setTwitterinfo(String twitterinfo) {
		this.twitterinfo = twitterinfo;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	
}
