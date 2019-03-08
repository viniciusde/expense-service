package com.denarde.finance.apiexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.denarde.finance.apiexpense.document.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
