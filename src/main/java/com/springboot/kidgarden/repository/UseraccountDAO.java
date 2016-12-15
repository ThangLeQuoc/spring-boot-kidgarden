package com.springboot.kidgarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.kidgarden.models.Useraccount;

public interface UseraccountDAO extends JpaRepository<Useraccount, Long> {
	@Query("SELECT user FROM Useraccount user WHERE user.username = ?")
	Useraccount findUser(String username);
	
	@Query("SELECT user FROM Useraccount user, Article article WHERE article.article_id = :article_id AND article.editor.username = user.username ")
	Useraccount findOneByArticle_Id(@Param("article_id") Long article_id);
}
