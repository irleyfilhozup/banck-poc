package com.example.service.interfaceSercice;

import java.util.List;

import com.example.domain.entity.Transfer;
import com.example.domain.request.CashoutRequest;
import com.example.domain.request.DepositRequest;
import com.example.domain.request.TransferRequest;
import com.example.domain.response.CashoutResponse;
import com.example.domain.response.DepositResponse;
import com.example.domain.response.TransferResponse;

public interface OperationService {

    String getBalance(Long accountId);

    DepositResponse deposit(DepositRequest depositRequest);

    TransferResponse transfer(TransferRequest transferRequest);

    CashoutResponse cashOut(CashoutRequest cashoutRequest);

    List<Transfer> getTransfers(Long id);

    void validTransfer(TransferRequest transferRequest);
}
