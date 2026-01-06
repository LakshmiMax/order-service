package com.app.order.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.order.model.Account;
import com.app.order.service.AccountService;

@ExtendWith(MockitoExtension.class)

public class AccountControllerTest {

	@InjectMocks
    private AccountController accountController;

    @Mock
    private AccountService accountService;

    @Test
    void createAccount_unitTest() {
        Account account = new Account();
        account.setId(1L);
        account.setName("tanuja");
        account.setEmail("trddftgh@ffgh12");
        Mockito.when(accountService.createAccount(account))
               .thenReturn(account);

        Account response = accountController.createAccount(account);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("tanuja", response.getName());
        assertEquals("trddftgh@ffgh12", response.getEmail());

    }
}












	
	

