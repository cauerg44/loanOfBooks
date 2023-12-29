package com.cauegarcia.system.repositories;

import com.cauegarcia.system.entities.BorrowedBook;
import com.cauegarcia.system.entities.BorrowedBookPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanItemRepository extends JpaRepository<BorrowedBook, BorrowedBookPK> {

}