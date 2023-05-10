package com.example.Caching_Spring_App.service;

import com.example.Caching_Spring_App.dto.request.BookRequestDto;
import com.example.Caching_Spring_App.dto.response.BookResponseDto;

public interface BookService {
    BookResponseDto addBook(BookRequestDto bookRequestDto);

    BookResponseDto getBook(Long bookId);

}
