package com.example.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.example.domain.entity.CashOut;
import com.example.domain.request.CashoutRequest;
import com.example.repository.CashOutRepository;
import com.example.service.interfaceSercice.CashOutService;

@Component
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CashOutServiceImpl implements CashOutService {

    @Autowired
    CashOutRepository cashOutRepository;

    @Override
    public CashOut create(CashoutRequest cashoutRequest) {
        CashOut cashOut = new CashOut(cashoutRequest.getAccountId(), cashoutRequest.getValue());
        return cashOutRepository.save(cashOut);
    }

    @Override
    public List<CashOut> findCustomeCashOuts(Long id) {
        return cashOutRepository.getCashOutById_account(id);
    }
}
