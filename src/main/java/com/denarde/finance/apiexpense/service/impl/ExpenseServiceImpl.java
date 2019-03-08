package com.denarde.finance.apiexpense.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denarde.finance.apiexpense.document.Expense;
import com.denarde.finance.apiexpense.repository.ExpenseRepository;
import com.denarde.finance.apiexpense.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	ExpenseRepository repository;

	@Override
	public List<Expense> findAll() {
		return repository.findAll();
	}

	@Override
	public Expense findById(Long id) {
		Optional<Expense> expenseData = repository.findById(id);
		
		if(expenseData.isPresent()) {
			return expenseData.get();
		}
		
		return null;
	}

	@Override
	public Expense save(Expense expense) {
		if(expense != null && expense.getDateTime() == null) {
			expense.setDateTime(LocalDateTime.now());
		}
		
		return repository.save(expense);
	}
	
	

}
