package com.example.kafkademo;

import lombok.ToString;

@ToString
public class TransactionDetails {
    private int fromAccount;
    private int toAccount;
    private int amount;

    public TransactionDetails() {
    }

    public TransactionDetails(int fromAccount, int toAccount, int amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
    }

    public int getToAccount() {
        return toAccount;
    }

    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
