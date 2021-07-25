package com.reactpro.services;



import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reactpro.dao.BooksModelRepository;
import com.reactpro.dao.models.BooksModel;

@Service
public class BooksService {
	
	@Autowired
	private BooksModelRepository booksModelRepository;
	
	@Transactional
	public void saveBook(BooksModel books){
		booksModelRepository.save(books);
	}
	
	@Transactional
	public BooksModel getBookById(Long id){
		Optional<BooksModel> booksModel = booksModelRepository.findById(id);
		if (!booksModel.isPresent())  throw new  EntityNotFoundException();
		return booksModel.isPresent() ? booksModel.get() : null;
	}

}
