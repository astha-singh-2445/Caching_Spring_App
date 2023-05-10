package com.example.Caching_Spring_App.dao;

import com.example.Caching_Spring_App.config.CacheStore;
import com.example.Caching_Spring_App.entity.Book;
import com.example.Caching_Spring_App.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Component
public class BookDao {

    private final BookRepository bookRepository;

    private final CacheStore<Long,Book> cacheStore;

    public BookDao(BookRepository bookRepository, @Qualifier("bookCache") CacheStore<Long, Book> cacheStore) {
        this.bookRepository = bookRepository;
        this.cacheStore = cacheStore;
    }
    public Book getById(Long id) {

        Optional<Book> cachedBookRecord = cacheStore.get(id);
        if(cachedBookRecord.isPresent()) {
            return cachedBookRecord.get();
        }
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Not Found");
        }

        Book book = bookOptional.get();
        cacheStore.put(id,book);
        return book;
    }
}
