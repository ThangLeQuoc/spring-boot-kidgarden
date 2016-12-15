package com.springboot.kidgarden.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.kidgarden.models.*;
import com.springboot.kidgarden.repository.*;

@Service
public class UserService {
	
	@Autowired
	private UseraccountDAO userRepository;
	
	public Useraccount getUser(String username){
		return userRepository.findUser(username);
	}
	
	public Useraccount getUserByArticleId(String article_id){
		Long id = Long.valueOf(article_id);
		return userRepository.findOneByArticle_Id(id);
	}
}
