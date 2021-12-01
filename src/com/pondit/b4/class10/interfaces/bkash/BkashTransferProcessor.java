package com.pondit.b4.class10.interfaces.bkash;

import com.pondit.b4.class10.interfaces.FundTransferProcessor;
import com.pondit.b4.class10.interfaces.PaymentInfo;

public class BkashTransferProcessor implements FundTransferProcessor {
    @Override
    public void process(PaymentInfo paymentInfo) {
        String bkashPaymentUrl = "";
//        checkUserSession(paymentInfo.getSender());
//        checkAvailableAmount(paymentInfo.getSender(), paymentInfo.getAmount());
//        send(paymentInfo.getSender(), paymentInfo.getReceiver(), paymentInfo.getAmount());

        System.out.println(
                "The amount of "+paymentInfo.getAmount()
                        + " has been sent to "+ paymentInfo.getReceiver()
                        + " from account "+paymentInfo.getSender() + " via BKash");
    }
}
