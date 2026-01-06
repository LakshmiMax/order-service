package com.app.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.order.model.Account;
import com.app.order.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
    private AccountService accountService;

	
	 @PostMapping("/saveAll")
	    public Account createAccount(@RequestBody Account account) {
	        return accountService.createAccount(account);
	    }
}
