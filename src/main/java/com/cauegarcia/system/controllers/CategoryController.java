package com.cauegarcia.system.controllers;

import com.cauegarcia.system.dto.CategoryDTO;
import com.cauegarcia.system.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAllBooks() {
        List<CategoryDTO> categories = service.findAllCategories();
        return ResponseEntity.ok(categories);
    }
}
