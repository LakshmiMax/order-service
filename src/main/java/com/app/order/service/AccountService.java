package com.app.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.order.model.Account;
import com.app.order.repository.AccountRepository;
@Service

public class AccountService {
	@Autowired
    private AccountRepository accountRepository;
	 public Account createAccount(Account account) {
	        return accountRepository.save(account);
	    }

}
