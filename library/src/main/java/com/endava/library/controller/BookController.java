package com.endava.library.controller;

import com.endava.library.dto.BookDto;
import com.endava.library.mapper.BookMapper;
import com.endava.library.model.Book;
import com.endava.library.service.BookService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/book")
@Slf4j
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Collection<BookDto> getAllBooks() {
        log.info("Request: getAllBooks()");
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookDto getBook(@PathVariable Long id) {
      return bookService.getBook(id);
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public BookDto createBook(@RequestBody @Valid BookDto bookDto){
        return bookService.createBook(bookDto);
    }

    @PutMapping(value = "/{id}", consumes = "application/json;charset=UTF-8")
    public BookDto updateBook(@PathVariable Long id, @RequestBody @Valid BookDto bookDto){
        return bookService.updateBook(id, bookDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

}
