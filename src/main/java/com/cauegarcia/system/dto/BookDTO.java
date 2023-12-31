package com.cauegarcia.system.dto;

import com.cauegarcia.system.entities.Book;
import com.cauegarcia.system.entities.Category;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookDTO {

    private Long id;
    @Size(min = 5, max = 75, message = "Name book must have 5 to 75 characters")
    @NotBlank(message = "Required field, it must have a name book")
    private String name;
    @NotNull(message = "Required field")
    @Positive(message = "Price cannot be equal or less than zero")
    private Double price;
    private LocalDate publicationYear;
    @Size(min = 12, message = "Descriptions must have at least 10 characters")
    private String description;

    @NotEmpty
    private List<CategoryDTO> categories = new ArrayList<>();

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
        for (Category cat : ent.getCategories()) {
            categories.add(new CategoryDTO(cat));
        }
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

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
