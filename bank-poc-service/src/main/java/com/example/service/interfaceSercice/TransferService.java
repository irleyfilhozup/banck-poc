package com.example.service.interfaceSercice;

import java.util.List;

import com.example.domain.entity.Transfer;
import com.example.domain.request.TransferRequest;

public interface TransferService {

    Transfer transfer(TransferRequest transferRequest);

    List<Transfer> getTransfers(Long id);
}
