package com.example.bankpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bankpoc.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
