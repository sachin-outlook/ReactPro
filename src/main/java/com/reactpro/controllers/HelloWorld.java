package com.reactpro.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reactpro.dao.models.BooksModel;
import com.reactpro.services.BooksService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@Api(value = "HelloWorld name", description = "REST API for Hello World", tags = { "Hello" })
@Validated
public class HelloWorld {
	
	@Autowired
	BooksService booksService;
	
	
	@GetMapping("/api/hello/getuser/{bookId}")
	@ApiOperation(value="Default Hello", tags = { "Hello" })
	@ResponseStatus(HttpStatus.OK)
	public BooksModel Hello(@PathVariable Long bookId ){
		return booksService.getBookById(bookId);
	}
	
	@GetMapping("/api/hello/userecho")
	@ApiOperation(value="Echo Hello", tags = { "Hello" })
	public String HelloUser(@Parameter String user){
		return "Hello " + user;
	}
	
	
	
	
	@PostMapping("/api/hello/savebook")
	@ApiOperation(value="Save Book", tags = { "Hello" })
	public ResponseEntity<BooksModel> saveBook(@RequestBody BooksModel book){
		booksService.saveBook(book);
		return ResponseEntity.ok(book);
		
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	 
	    ex.getBindingResult().getFieldErrors().forEach(error -> 
	        errors.put(error.getField(), error.getDefaultMessage()));
	     
	    return errors;
	}
	
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(RuntimeException.class)
//	public Map<String, String > handleDataAccessException(RuntimeException ex){
//		Map<String, String> errors = new HashMap<>();
//		errors.put("error", ex.getMessage());
//		return errors;
//	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DataAccessException.class)
	public Map<String, String > handleDataAccessException1(RuntimeException ex){
		Map<String, String> errors = new HashMap<>();
		errors.put("error", ex.getMessage());
		return errors;
	}
	
	
	
	
	/*
	 * https://kalliphant.com/swagger-spring-rest-controllername-change/
	 */
	
	/*
	 * https://reflectoring.io/bean-validation-with-spring-boot/
	 * 
	 */
	
	
	
	
}
