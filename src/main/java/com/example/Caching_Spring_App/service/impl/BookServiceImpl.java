package com.example.Caching_Spring_App.service.impl;

import com.example.Caching_Spring_App.dao.BookDao;
import com.example.Caching_Spring_App.dto.request.BookRequestDto;
import com.example.Caching_Spring_App.dto.response.BookResponseDto;
import com.example.Caching_Spring_App.entity.Book;
import com.example.Caching_Spring_App.repository.BookRepository;
import com.example.Caching_Spring_App.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookDao bookDao;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookDao bookDao) {
        this.bookRepository = bookRepository;
        this.bookDao = bookDao;
    }


    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {

        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());

        book = bookRepository.save(book);
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setTitle(book.getTitle());
        return bookResponseDto;
    }

    @Override
    public BookResponseDto getBook(Long id) {
        Book book = bookDao.getById(id);
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setTitle(book.getTitle());
        return bookResponseDto;
    }
}
