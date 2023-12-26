package com.cauegarcia.system.services;

import com.cauegarcia.system.entities.Book;
import com.cauegarcia.system.entities.dto.BookDTO;
import com.cauegarcia.system.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Transactional(readOnly = true)
    public BookDTO findById(Long id) {
        Optional<Book> response = repository.findById(id);
        Book book = response.get();
        BookDTO dto = new BookDTO(book);
        return dto;
    }

    @Transactional(readOnly = true)
    public Page<BookDTO> findAllBooks(Pageable pageable) {
        Page<Book> response = repository.findAll(pageable);
        return response.map(x -> new BookDTO(x));
    }
}
