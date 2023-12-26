package com.cauegarcia.system.controllers;

import com.cauegarcia.system.entities.Book;
import com.cauegarcia.system.entities.dto.BookDTO;
import com.cauegarcia.system.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BooksController {

    @Autowired
    private BookService service;

    @GetMapping(value = "/{id}")
    public BookDTO findById(@PathVariable Long id) {
        BookDTO bookDTO = service.findById(id);
        return bookDTO;
    }

    @GetMapping
    public Page<BookDTO> findAllBooks(Pageable pageable) {
        return service.findAllBooks(pageable);
    }
}
