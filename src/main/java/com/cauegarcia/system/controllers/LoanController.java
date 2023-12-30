package com.cauegarcia.system.controllers;

import com.cauegarcia.system.dto.LoanDTO;
import com.cauegarcia.system.services.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<LoanDTO> findById(@PathVariable Long id) {
        LoanDTO bookDTO = service.findById(id);
        return ResponseEntity.ok(bookDTO);
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<LoanDTO> insert(@Valid @RequestBody LoanDTO loanDTO) {
        loanDTO = service.insert(loanDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(loanDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(loanDTO);
    }
}
