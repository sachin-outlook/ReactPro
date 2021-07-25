package com.reactpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reactpro.dao.models.BooksModel;

@Repository
public interface BooksModelRepository extends JpaRepository<BooksModel, Long>{

}
