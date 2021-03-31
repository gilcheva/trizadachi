package com.endava.library.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="books", uniqueConstraints = @UniqueConstraint(columnNames = {"book_name"}))
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="book_name")
    @Size(max=200)
    private String name;
}
