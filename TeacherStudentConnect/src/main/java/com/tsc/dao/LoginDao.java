package com.tsc.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsc.entity.User;

@Repository
public interface LoginDao extends JpaRepository<User, Integer>{
	
	Optional<User> findByUsername(String username);
}
