package com.reactpro.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reactpro.dao.models.Users;
import com.reactpro.reqbeans.User;
import com.reactpro.services.UsersService;
import com.reactproexceptions.ExceptionResponse;
import com.reactproexceptions.UserNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Users API", 
//description="API to add, modify, delete users", 
tags={"Users"})
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	
	
	@GetMapping("/api/users/getAllUsers/{userId}")
	@ApiOperation(value="Get  User  by ID", tags = { "Users" })
	@ResponseStatus(HttpStatus.OK)
	public Users getUserById(@PathVariable @Min(1) Integer userId){
		return usersService.getUserById(userId);
	}
	

	@GetMapping("/api/users/getAllUsers")
	@ApiOperation(value="Get All User", tags = { "Users" })
	@ResponseStatus(HttpStatus.OK)
	public List<Users> getUser(){
		return usersService.getAllUsers();
		
	}
	
	@PostMapping("/api/users/adduser")
	@ApiOperation(value="Save User", tags = { "Users" })
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@Valid @RequestBody User user){
		
		Users users = usersService.saveUser(user);
		user.setUserId( users.getId());
		return user;
		
	}
	
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidMethodArgument( MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
		.forEach(
				error -> errors.put(error.getField() , error.getDefaultMessage())
				);
		
		return errors;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ExceptionResponse userNotFoundException (final UserNotFoundException ex,
			final HttpServletRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErrorMessage(ex.getMessage());
		exceptionResponse.setRequestedURI(request.getRequestURI());
		return exceptionResponse;
	}
	
	
	
}
