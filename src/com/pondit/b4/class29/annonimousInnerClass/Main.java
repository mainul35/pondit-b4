package com.pondit.b4.class29.annonimousInnerClass;

public class Main {
    public static void main(String[] args) {
        ProcessBkashPayment bkashPayment = new ProcessBkashPayment();
//        BKashPaymentProcessor processor = new BKashPaymentProcessor();
        bkashPayment.checkAndProcess(new BKashPaymentProcessor());

        ProcessVisaPayment processVisaPayment = new ProcessVisaPayment();
        processVisaPayment.checkAndProcess(new PaymentProcessor() {
            @Override
            public void process() {
                System.out.println("Processing visa payment");
            }
        });
    }
}

class ProcessBkashPayment {
    boolean isAmountAvailable = true;
    public void checkAndProcess(PaymentProcessor processor) {
        if(isAmountAvailable) {
            processor.process();
        }
    }
}

class ProcessVisaPayment {
    boolean isAmountAvailable = true;
    public void checkAndProcess(PaymentProcessor processor) {
        if(isAmountAvailable) {
            processor.process();
        }
    }
}

class BKashPaymentProcessor implements PaymentProcessor {

    @Override
    public void process() {
        System.out.println("Sending from one BKash account to another");
    }
}