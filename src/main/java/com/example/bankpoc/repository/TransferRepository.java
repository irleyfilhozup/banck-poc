package com.example.bankpoc.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bankpoc.models.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer> {

    @Query(value = "SELECT * FROM transfer WHERE id_account_source = ?1 OR id_destination_account = ?1", name =
            "findTransactions", nativeQuery = true)
    Collection<Transfer> findByTransactionWithId(Integer id);
}
