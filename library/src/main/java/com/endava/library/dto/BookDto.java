package com.endava.library.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BookDto {

    private Long id;

    @NotNull
    @Size(max=200)
    private String name;
}
