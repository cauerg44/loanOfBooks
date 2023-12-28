package com.cauegarcia.system.controllers;

import com.cauegarcia.system.entities.Book;
import com.cauegarcia.system.entities.dto.BookDTO;
import com.cauegarcia.system.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/books")
public class BooksController {

    @Autowired
    private BookService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable Long id) {
        BookDTO bookDTO = service.findById(id);
        return ResponseEntity.ok(bookDTO);
    }

    @GetMapping
    public ResponseEntity<Page<BookDTO>> findAllBooks(Pageable pageable) {
        Page<BookDTO> bookDTO = service.findAllBooks(pageable);
        return ResponseEntity.ok(bookDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<BookDTO> insert(@Valid @RequestBody BookDTO bookDTO) {
        bookDTO = service.insert(bookDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(bookDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(bookDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
        bookDTO = service.update(id, bookDTO);
        return ResponseEntity.ok(bookDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
