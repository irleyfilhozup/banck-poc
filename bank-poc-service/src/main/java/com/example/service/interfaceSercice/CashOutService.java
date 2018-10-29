package com.example.service.interfaceSercice;

import java.util.List;
import com.example.domain.entity.CashOut;
import com.example.domain.request.CashoutRequest;

public interface CashOutService {

    CashOut create(CashoutRequest cashoutRequest);

    List<CashOut> findCustomeCashOuts(Long id);
}
