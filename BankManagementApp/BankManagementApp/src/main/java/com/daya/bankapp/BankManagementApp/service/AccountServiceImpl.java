package com.daya.bankapp.BankManagementApp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daya.bankapp.BankManagementApp.entity.Account;
import com.daya.bankapp.BankManagementApp.repo.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository repo;
	
	@Override
	public Account createAccount(Account account) {
		Account account_saved=repo.save(account);
		
		return account_saved;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
	    return repo.findById(accountNumber)
	               .orElseThrow(() -> new RuntimeException("Account is not present"));
	}


	@Override
	public List<Account> getAllAccountDetails() {
		List<Account> listOfAccount=repo.findAll();
		
		return listOfAccount;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
	    Account account = repo.findById(accountNumber)
	                          .orElseThrow(() -> new RuntimeException("Account is not present"));

	    // Update balance
	    account.setAccount_balance(account.getAccount_balance() + amount);

	    // Save updated account
	    return repo.save(account);
	}


	@Override
	public Account withdrwaAmount(Long accountNumber, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeAccount(Long accountNumber) {
	    Account account = repo.findById(accountNumber)
	                          .orElseThrow(() -> new RuntimeException("Account is not present"));

	    repo.delete(account);
	}


	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
	    if (amount == null || amount <= 0) {
	        throw new IllegalArgumentException("Withdrawal amount must be greater than zero");
	    }

	    Account account = repo.findById(accountNumber)
	                          .orElseThrow(() -> new RuntimeException("Account is not present"));

	    if (account.getAccount_balance() < amount) {
	        throw new RuntimeException("Insufficient balance");
	    }

	    // Deduct the amount
	    account.setAccount_balance(account.getAccount_balance() - amount);

	    // Save updated account
	    return repo.save(account);
	}


}
