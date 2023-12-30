package com.cauegarcia.system.services;

import com.cauegarcia.system.dto.CategoryDTO;
import com.cauegarcia.system.entities.Category;
import com.cauegarcia.system.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAllCategories() {
        List<Category> response = repository.findAll();
        return response.stream().map(x -> new CategoryDTO(x)).toList();
    }
}
