package com.va.tracker.login.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.va.tracker.login.db.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("from User u where u.userid= ?1")
	public User getUserByUsername(String userid);

}