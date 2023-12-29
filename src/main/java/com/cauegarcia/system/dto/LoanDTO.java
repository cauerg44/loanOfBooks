package com.cauegarcia.system.dto;

import com.cauegarcia.system.entities.BorrowedBook;
import com.cauegarcia.system.entities.Loan;
import com.cauegarcia.system.entities.enums.LoanStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class LoanDTO {

    private Long id;
    private Instant moment;
    private LoanStatus status;

    private ClientDTO client;

    private List<LoanItemDTO> books = new ArrayList<>();

    public LoanDTO(Long id, Instant moment, LoanStatus status, ClientDTO client) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LoanDTO(Loan loan) {
        id = loan.getId();
        moment = loan.getMoment();
        status = loan.getStatus();
        client = new ClientDTO(loan.getClient());
        for (BorrowedBook book : loan.getItems()) {
            LoanItemDTO itemDTO = new LoanItemDTO(book);
            books.add(itemDTO);
        }
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public List<LoanItemDTO> getBooks() {
        return books;
    }

    public Double getTotal() {
        double sum = 0.0;
        for (LoanItemDTO book : books) {
            sum += book.getSubTotal();
        }
        return sum;
    }
}
