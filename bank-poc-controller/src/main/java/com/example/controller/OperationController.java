package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.domain.entity.Transfer;
import com.example.domain.request.CashoutRequest;
import com.example.domain.request.DepositRequest;
import com.example.domain.request.TransferRequest;
import com.example.domain.response.CashoutResponse;
import com.example.domain.response.DepositResponse;
import com.example.domain.response.TransferResponse;
import com.example.service.interfaceSercice.OperationService;

@RestController
@RequestMapping(path = "/operation")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping(value = "/balance/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> balance(@PathVariable("accountId") Integer accountId) {
        String balance = operationService.getBalance(Long.valueOf(accountId));
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }

    @PostMapping(value = "/deposit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deposit(@RequestBody DepositRequest depositRequest) {
        DepositResponse depositResponse = operationService.deposit(depositRequest);
        return new ResponseEntity<>(depositResponse, HttpStatus.OK);
    }

    @PostMapping( value = "/cashout", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity cashOut(@RequestBody CashoutRequest cashoutRequest) {
        CashoutResponse cashoutResponse = operationService.cashOut(cashoutRequest);
        return new ResponseEntity<>(cashoutResponse, HttpStatus.OK);
    }

    @PostMapping( value = "/transfer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity transfer(@RequestBody TransferRequest transferRequest) {
        TransferResponse transferResponse = operationService.transfer(transferRequest);
        return new ResponseEntity<>(transferResponse, HttpStatus.OK);
    }

    @GetMapping( value = "accountStatement/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity accountStatement(@PathVariable("accountId") Integer accountId) {
        List<Transfer> transfers = operationService.getTransfers(Long.valueOf(accountId));
        return new ResponseEntity<>(transfers, HttpStatus.OK);
    }
}