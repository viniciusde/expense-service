package com.denarde.finance.apiexpense.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.denarde.finance.apiexpense.document.Expense;
import com.denarde.finance.apiexpense.service.ExpenseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Expense Controller")
public class ExpenseController {
	
	@Autowired
	ExpenseService service;
	
	@GetMapping("/expenses")
	@ApiOperation(value="Return all Expenses")
	public ResponseEntity<List<Expense>> getAll() {
		List<Expense> expenses = service.findAll();
		 return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	@GetMapping("/expenses/{id}")
	@ApiOperation(value="Return Expense")
	public ResponseEntity<Expense> getExpense(@PathVariable("id") String id) {
		Expense expenseData = service.findById(Long.valueOf(id));
		
		if(expenseData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(expenseData, HttpStatus.OK);
	}
	
	@PostMapping("/expenses")
	@ApiOperation(value="Create new Expense")
	public ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) throws Exception {
		return new ResponseEntity<>(service.save(expense), HttpStatus.OK);
	}

}
