package com.cauegarcia.system.dto;

import com.cauegarcia.system.entities.BorrowedBook;

public class LoanItemDTO {

    private Long bookId;
    private String name;
    private Double price;
    private Integer quantity;

    public LoanItemDTO(Long bookId, String name, Double price, Integer quantity) {
        this.bookId = bookId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public LoanItemDTO(BorrowedBook loanItem) {
        bookId = loanItem.getBook().getId();
        name = loanItem.getBook().getName();
        price = loanItem.getPrice();;
        quantity = loanItem.getQuantity();
    }

    public Long getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getSubTotal() {
        return price * quantity;
    }
}
