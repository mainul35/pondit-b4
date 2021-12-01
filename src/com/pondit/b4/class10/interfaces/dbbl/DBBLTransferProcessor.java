package com.pondit.b4.class10.interfaces.dbbl;

import com.pondit.b4.class10.interfaces.FundTransferProcessor;
import com.pondit.b4.class10.interfaces.PaymentInfo;

public class DBBLTransferProcessor implements FundTransferProcessor {
    @Override
    public void process(PaymentInfo paymentInfo) {
        System.out.println(
                "The amount of "+paymentInfo.getAmount()
                        + " has been sent to "+ paymentInfo.getReceiver()
                        + " from account "+paymentInfo.getSender() + " via DBBL");
    }
}
