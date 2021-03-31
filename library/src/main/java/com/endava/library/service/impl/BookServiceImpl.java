package com.endava.library.service.impl;

import com.endava.library.dto.BookDto;
import com.endava.library.mapper.BookMapper;
import com.endava.library.model.Book;
import com.endava.library.repository.BookRepository;
import com.endava.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Collection<BookDto> getAllBooks(){
        return bookMapper.toDto(bookRepository.findAll());
    }

    @Override
    public BookDto getBook(Long id) {
        return bookMapper.toDto(bookRepository.findOneById(id));
    }

    @Override
    public BookDto createBook(@Valid BookDto bookDto){
        Book book = Optional.of(bookDto).map(bookMapper::toEntity).get();

        book = bookRepository.save (book);
        return Optional.of(book).map(bookMapper::toDto).get();
    }

    @Override
    public BookDto updateBook(Long id, @Valid BookDto bookDto){
        Book book = Optional.of(bookDto).map(bookMapper::toEntity).get();
        book.setId(id);
       book = bookRepository.save(book);
        return Optional.of(book).map(bookMapper::toDto).get();
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
