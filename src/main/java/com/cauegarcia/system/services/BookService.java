package com.cauegarcia.system.services;

import com.cauegarcia.system.dto.CategoryDTO;
import com.cauegarcia.system.dto.LoanDTO;
import com.cauegarcia.system.dto.LoanItemDTO;
import com.cauegarcia.system.entities.*;
import com.cauegarcia.system.dto.BookDTO;
import com.cauegarcia.system.entities.enums.LoanStatus;
import com.cauegarcia.system.repositories.BookRepository;
import com.cauegarcia.system.repositories.LoanItemRepository;
import com.cauegarcia.system.services.exceptions.DatabaseException;
import com.cauegarcia.system.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Transactional(readOnly = true)
    public BookDTO findById(Long id) {
        Book book = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        return new BookDTO(book);
    }

    @Transactional(readOnly = true)
    public Page<BookDTO> findAllBooks(Pageable pageable) {
        Page<Book> response = repository.findAll(pageable);
        return response.map(x -> new BookDTO(x));
    }

    @Transactional
    public BookDTO insert(BookDTO bookDTO) {
        Book newBook = new Book();
        getDtoToEntity(bookDTO, newBook);
        newBook = repository.save(newBook);
        return new BookDTO(newBook);
    }

    @Transactional
    public BookDTO update(Long id, BookDTO bookDTO) {
        try{
            Book newBook = repository.getReferenceById(id);
            getDtoToEntity(bookDTO, newBook);
            newBook = repository.save(newBook);
            return new BookDTO(newBook);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Resource not found");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Referential integrity error.");
        }
    }

    private void getDtoToEntity(BookDTO bookDTO, Book newBook) {
        newBook.setName(bookDTO.getName());
        newBook.setDescription(bookDTO.getDescription());
        newBook.setPrice(bookDTO.getPrice());
        newBook.setPublicationYear(bookDTO.getPublicationYear());

        newBook.getCategories().clear();
        for (CategoryDTO categoryDTO : bookDTO.getCategories()) {
            Category cat = new Category();
            cat.setId(categoryDTO.getId());
            newBook.getCategories().add(cat);
        }
    }
}
