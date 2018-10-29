package com.example.service.interfaceSercice;

import java.util.List;

import com.example.domain.entity.Deposit;

public interface DepositService {

    Deposit create(Deposit newDeposit);

    List<Deposit> findCustomerDeposits(Long id);
}
