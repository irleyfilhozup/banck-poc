package com.example.bankpoc.repository;

import java.util.Collection;

import com.example.bankpoc.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByCpf(String cpf);
}
