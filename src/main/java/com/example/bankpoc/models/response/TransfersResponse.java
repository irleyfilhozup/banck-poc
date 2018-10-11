package com.example.bankpoc.models.response;

import java.util.ArrayList;
import java.util.List;
import com.example.bankpoc.models.entity.CashOut;
import com.example.bankpoc.models.entity.Deposit;
import com.example.bankpoc.models.entity.Transfer;

public class TransfersResponse {

    private List transactions = new ArrayList();

    private List<Transfer> transferList;
    private List<Deposit> depositList;
    private List<CashOut>cashOutList;


    public TransfersResponse(List<Transfer> transferList, List<Deposit> depositList, List<CashOut>cashOutList){
        this.transferList = transferList;
        this.depositList = depositList;
        this.cashOutList = cashOutList;
        loadList();
    }

    private void loadList() {
        for(Transfer transfer : transferList) {
            transactions.add(transfer);
        }

        for(Deposit deposit : depositList) {
            transactions.add(deposit);
        }

        for(CashOut cashOut : cashOutList) {
            transactions.add(cashOut);
        }
    }

    public List getTransactions() {
        return transactions;
    }

    public void setTransactions(List transactions) {
        this.transactions = transactions;
    }
}
