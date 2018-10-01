package com.example.bankpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bankpoc.models.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer> {
}
