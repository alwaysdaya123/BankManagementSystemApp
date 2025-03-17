package com.daya.bankapp.BankManagementApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daya.bankapp.BankManagementApp.entity.Account;

public interface AccountRepository  extends JpaRepository<Account,Long>{

}
