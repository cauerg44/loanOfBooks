package com.cauegarcia.system.controllers;

import com.cauegarcia.system.dto.BookDTO;
import com.cauegarcia.system.dto.LoanDTO;
import com.cauegarcia.system.services.BookService;
import com.cauegarcia.system.services.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/loans")
public class LoanController {

    @Autowired
    private LoanService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<LoanDTO> findById(@PathVariable Long id) {
        LoanDTO bookDTO = service.findById(id);
        return ResponseEntity.ok(bookDTO);
    }
}
