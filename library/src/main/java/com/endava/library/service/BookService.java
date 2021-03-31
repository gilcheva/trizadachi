package com.endava.library.service;

import com.endava.library.dto.BookDto;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Collection;

@Service
public interface BookService {

    Collection<BookDto> getAllBooks();

    BookDto getBook(Long id);

    BookDto createBook(@Valid BookDto bookDto);

    BookDto updateBook(Long id, @Valid BookDto bookDto);

    void deleteBook(Long id);
}
