package com.cauegarcia.system.services;


import com.cauegarcia.system.dto.LoanDTO;
import com.cauegarcia.system.dto.LoanItemDTO;
import com.cauegarcia.system.entities.Book;
import com.cauegarcia.system.entities.BorrowedBook;
import com.cauegarcia.system.entities.Loan;
import com.cauegarcia.system.entities.User;
import com.cauegarcia.system.entities.enums.LoanStatus;
import com.cauegarcia.system.repositories.BookRepository;
import com.cauegarcia.system.repositories.LoanItemRepository;
import com.cauegarcia.system.repositories.LoanRepository;
import com.cauegarcia.system.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LoanItemRepository loanItemRepository;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public LoanDTO findById(Long id) {
        Loan loan = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found"));
        return new LoanDTO(loan);
    }

    @Transactional
    public LoanDTO insert(LoanDTO loanDTO) {
        Loan loan = new Loan();

        loan.setMoment(Instant.now());
        loan.setStatus(LoanStatus.WAITING);

        User user = userService.authenticated();
        loan.setClient(user);

        for (LoanItemDTO itemDTO : loanDTO.getBooks()) {
            Book book = bookRepository.getReferenceById(itemDTO.getBookId());
            BorrowedBook bb = new BorrowedBook(loan, book, itemDTO.getQuantity(), book.getPrice());
            loan.getItems().add(bb);
        }

        repository.save(loan);
        loanItemRepository.saveAll(loan.getItems());

        return new LoanDTO(loan);
    }
}
