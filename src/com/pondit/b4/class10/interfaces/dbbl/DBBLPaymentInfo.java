package com.pondit.b4.class10.interfaces.dbbl;

import com.pondit.b4.class10.interfaces.PaymentInfo;

public class DBBLPaymentInfo implements PaymentInfo {
    private String sender;
    private String receiver;
    private Double amount;
    @Override
    public String getSender() {
        return sender;
    }

    @Override
    public String getReceiver() {
        return receiver;
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
