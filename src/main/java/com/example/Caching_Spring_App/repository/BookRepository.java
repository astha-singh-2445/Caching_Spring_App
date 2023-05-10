package com.example.Caching_Spring_App.repository;

import com.example.Caching_Spring_App.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
