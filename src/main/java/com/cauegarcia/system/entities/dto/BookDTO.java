package com.cauegarcia.system.entities.dto;

import com.cauegarcia.system.entities.Book;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class BookDTO {

    private Long id;
    private String name;
    private Double price;
    private LocalDate publicationYear;
    private String description;

    public BookDTO(){
    }

    public BookDTO(Long id, String name, Double price, LocalDate publicationYear, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.publicationYear = publicationYear;
        this.description = description;
    }

    public BookDTO(Book ent){
        id = ent.getId();
        name = ent.getName();
        price = ent.getPrice();
        publicationYear = ent.getPublicationYear();
        description = ent.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public String getDescription() {
        return description;
    }
}
