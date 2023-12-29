package com.cauegarcia.system.services;


import com.cauegarcia.system.dto.LoanDTO;
import com.cauegarcia.system.entities.Book;
import com.cauegarcia.system.entities.Loan;
import com.cauegarcia.system.repositories.LoanRepository;
import com.cauegarcia.system.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;

    @Transactional(readOnly = true)
    public LoanDTO findById(Long id) {
        Loan loan = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found"));
        return new LoanDTO(loan);
    }
}
