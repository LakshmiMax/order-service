package com.app.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.order.model.Account;
import com.app.order.repository.AccountRepository;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Create Account
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // Get Account by ID
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id " + id));
    }

    // Get All Accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Delete Account
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}