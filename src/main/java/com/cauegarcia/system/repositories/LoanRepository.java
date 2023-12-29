package com.cauegarcia.system.repositories;

import com.cauegarcia.system.entities.Loan;
import com.cauegarcia.system.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

}