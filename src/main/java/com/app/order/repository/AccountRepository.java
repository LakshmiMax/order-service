package com.app.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.order.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}