package com.springboot.kidgarden.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="useraccount")
public class LeQuocThang_04_Useraccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String username;
	
	private String name;
	private String password;
	private String facebookinfo;
	private String googlegmailinfo;
	private String twitterinfo;
	private String phonenumber;
	
	@OneToMany(mappedBy = "editor")
	private Set<LeQuocThang_04_Article>articles;
}
