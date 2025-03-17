package com.daya.bankapp.BankManagementApp.controller;

import org.apache.catalina.connector.Response;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daya.bankapp.BankManagementApp.entity.Account;
import com.daya.bankapp.BankManagementApp.service.AccountService;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired 
	AccountService service;
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account createAccount=service.createAccount(account);
		
	return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
}
	@GetMapping("/{accountNumber}")
	public Account getAccountByAccountNuber(@PathVariable Long accountNumber) {
		Account account=service.getAccountDetailsByAccountNumber(accountNumber);
		return account;
	}
	
	@GetMapping("/getallaccounts")
	public java.util.List<Account> getAllAccountDetails() {
	      return service.getAllAccountDetails();
	    
	}
	


	@PutMapping("deposit/{accountNumber}/{amount}")
	public Account depositAccount(@PathVariable Long accountNumber, @PathVariable Double amount) {
	    return service.depositAmount(accountNumber, amount);
	}
	@PutMapping("withdraw/{accountNumber}/{amount}")
	public Account withdrawAccount(@PathVariable Long accountNumber, @PathVariable Double amount) {
	    return service.withdrawAmount(accountNumber, amount);
	}

	@DeleteMapping("close/{accountNumber}")
	public ResponseEntity<String> closeAccount(@PathVariable Long accountNumber) {
	    service.closeAccount(accountNumber);
	    return ResponseEntity.ok("Account with number " + accountNumber + " has been closed successfully.");
	}

	
	
}
