package com.example.bankpoc.models.response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.example.bankpoc.models.entity.CashOut;
import com.example.bankpoc.models.entity.Deposit;
import com.example.bankpoc.models.entity.Transaction;
import com.example.bankpoc.models.entity.Transfer;
import com.example.bankpoc.models.enums.TypeTransfer;

public class TransfersResponse {

    private List<Transaction> transactions = new ArrayList();

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
        for (Transfer transfer : transferList) {
            transactions.add(new Transaction(transfer.getAccountIdDesposit(),
                    transfer.getAccountIdRecipient(),
                    transfer.getDate(),
                    transfer.getValue(),
                    TypeTransfer.TRANSFER));
        }

        for(Deposit deposit : depositList) {
            transactions.add(new Transaction(deposit.getId_account(),
                    deposit.getDate(),
                    deposit.getValue(),
                    TypeTransfer.DEPOSIT));
        }

        for(CashOut cashOut : cashOutList) {
            transactions.add(new Transaction(cashOut.getDate(),
                    cashOut.getAccountId(),
                    cashOut.getValue(),
                    TypeTransfer.CASHOUT));
        }

        Collections.sort(transactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction transaction1, Transaction transaction2)
            {

                return  transaction1.getDate().compareTo(transaction2.getDate());
            }
        });
    }

    public List getTransactions() {
        return transactions;
    }

    public void setTransactions(List transactions) {
        this.transactions = transactions;
    }
}
