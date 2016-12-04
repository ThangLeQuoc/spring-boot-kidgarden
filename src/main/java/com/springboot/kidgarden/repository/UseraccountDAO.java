package com.springboot.kidgarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.kidgarden.models.Useraccount;

public interface UseraccountDAO extends JpaRepository<Useraccount, Long> {
	@Query("SELECT user FROM Useraccount user WHERE user.username = ?")
	Useraccount findUser(String username);
}
