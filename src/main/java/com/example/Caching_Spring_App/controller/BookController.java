package com.example.Caching_Spring_App.controller;

import com.example.Caching_Spring_App.dto.request.BookRequestDto;
import com.example.Caching_Spring_App.dto.response.BookResponseDto;
import com.example.Caching_Spring_App.dto.response.ResponseWrapper;
import com.example.Caching_Spring_App.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {


    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping()
    public ResponseEntity<ResponseWrapper<BookResponseDto>> addBook(@RequestBody @Valid BookRequestDto bookRequestDto) {
        BookResponseDto bookResponseDto = bookService.addBook(bookRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseWrapper.success(bookResponseDto));
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<ResponseWrapper<BookResponseDto>> getBook(@PathVariable Long bookId) {
        BookResponseDto bookResponseDto = bookService.getBook(bookId);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseWrapper.success(bookResponseDto));
    }
}
