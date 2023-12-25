package com.cauegarcia.system.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_book_item")
public class BorrowedBook {

    @EmbeddedId
    private BorrowedBookPK id = new BorrowedBookPK();

    private Integer quantity;
    private Double price;

    public BorrowedBook(){
    }

    public BorrowedBook(Loan loan, Book book, Integer quantity, Double price) {
        id.setLoan(loan);
        id.setBook(book);
        this.quantity = quantity;
        this.price = price;
    }

    public Loan getLoan(){
        return id.getLoan();
    }

    public void setLoan(Loan loan){
        id.setLoan(loan);
    }

    public Book getBook(){
        return id.getBook();
    }

    public void setBook(Book book){
        id.setBook(book);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
