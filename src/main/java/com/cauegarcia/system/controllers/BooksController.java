package com.cauegarcia.system.controllers;

import com.cauegarcia.system.entities.dto.BookDTO;
import com.cauegarcia.system.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public BookDTO insert(@RequestBody BookDTO bookDTO) {
        return service.insert(bookDTO);
    }
}
