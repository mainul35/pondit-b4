package com.pondit.b4.class10.interfaces;

import com.pondit.b4.class10.interfaces.bkash.BkashPaymentInfo;
import com.pondit.b4.class10.interfaces.bkash.BkashTransferProcessor;
import com.pondit.b4.class10.interfaces.dbbl.DBBLPaymentInfo;
import com.pondit.b4.class10.interfaces.dbbl.DBBLTransferProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaymentProcessorRunner {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please select your payment gateway: ");
        System.out.println("1 = BKash");
        System.out.println("2 = DBBL");
        FundTransferProcessor processor;
        String line = reader.readLine();
        switch (line) {
            case "1":
                System.out.println("BKash Selected");
                processor = new BkashTransferProcessor();
                System.out.println("Please provide sender number: ");
                String sender = reader.readLine();
                System.out.println("Please provide receiver number: ");
                String receiver = reader.readLine();
                System.out.println("Please provide amount ");
                Double amount = Double.parseDouble(reader.readLine());
                BkashPaymentInfo bkashPaymentInfo = new BkashPaymentInfo();
                bkashPaymentInfo.setSender(sender);
                bkashPaymentInfo.setReceiver(receiver);
                bkashPaymentInfo.setAmount(amount);
                processor.process(bkashPaymentInfo);
                break;
            case "2":
                System.out.println("DBBL Selected");
                processor = new DBBLTransferProcessor();
                System.out.println("Please provide sender number: ");
                sender = reader.readLine();
                System.out.println("Please provide receiver number: ");
                receiver = reader.readLine();
                System.out.println("Please provide amount ");
                amount = Double.parseDouble(reader.readLine());
                DBBLPaymentInfo dbblPaymentInfo = new DBBLPaymentInfo();
                dbblPaymentInfo.setAmount(amount);
                dbblPaymentInfo.setSender(sender);
                dbblPaymentInfo.setReceiver(receiver);
                processor.process(dbblPaymentInfo);
                break;
            default:
                System.out.println("No matching payment processor found.");
                break;
        }
    }
}
