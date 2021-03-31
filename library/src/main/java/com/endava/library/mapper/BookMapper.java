package com.endava.library.mapper;

import com.endava.library.dto.BookDto;
import com.endava.library.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring", uses={})
public interface BookMapper extends EntityMapper<BookDto, Book> {

}
