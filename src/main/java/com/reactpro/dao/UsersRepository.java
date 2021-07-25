package com.reactpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reactpro.dao.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	


}
