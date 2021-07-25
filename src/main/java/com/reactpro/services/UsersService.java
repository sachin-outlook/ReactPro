package com.reactpro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.reactpro.dao.UsersRepository;
import com.reactpro.dao.models.Users;
import com.reactpro.reqbeans.User;
import com.reactproexceptions.UserNotFoundException;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository usersRepository;
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRES_NEW)
	public Users saveUser(User user){
		
		Users mUsres = new Users(user.getFname(), user.getLname(), user.getAge());
		Users savedUsers = usersRepository.save(mUsres);
		if(user.getUserId() ==0 ){
			throw new RuntimeException();
		}
		return savedUsers;
		
	}
	
	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}
	
	public Users getUserById(long userId){
		Optional<Users> users = usersRepository.findById(userId);
		if (!users.isPresent()){
			throw new UserNotFoundException("User ${userId} Not Found");
		}
		
		return users.get();
			
		
	}
	
}
