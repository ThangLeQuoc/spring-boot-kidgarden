package com.springboot.kidgarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.kidgarden.models.Useraccount;

public interface UseraccountDAO extends JpaRepository<Useraccount, Long> {

}
