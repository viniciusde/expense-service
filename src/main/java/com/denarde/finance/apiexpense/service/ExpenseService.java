package com.denarde.finance.apiexpense.service;

import java.util.List;

import com.denarde.finance.apiexpense.document.Expense;

public interface ExpenseService {
	
	List<Expense> findAll();
	
	Expense findById(Long id);
	
	Expense save(Expense expense);

}
