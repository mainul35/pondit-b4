package com.pondit.b4.class9.abstraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AtmBooth extends AbstractAtmBooth {

    @Override
    void performPayment() throws IOException {
        System.out.println("Please provide bank input: " );
        String bankName = getBank(1);
        setAmount(60);
        System.out.println("Selected Bank: " + bankName);
        System.out.println("Amount: "+ getAmount());
    }
}

class AtmBoothRunner {
//    public static void withAnonymousInnerClass() throws IOException {
//        AbstractAtmBooth booth = new AbstractAtmBooth() {
//            @Override
//            void performPayment() throws IOException {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//                System.out.println("Please enter bank name: ");
//                String bank = getBank(Integer.parseInt(reader.readLine()));
//                System.out.println("Please enter amount: ");
//                this.setAmount(Integer.parseInt(reader.readLine()));
//                System.out.println("Your selected bank is: "+ bank);
//                System.out.println("Amount: " + getAmount());
//
//            }
//        };
//
//        booth.performPayment();
//    }

    public static void main(String[] args) throws IOException {
        AbstractAtmBooth booth = new AtmBooth();
        booth.performPayment();
    }
}