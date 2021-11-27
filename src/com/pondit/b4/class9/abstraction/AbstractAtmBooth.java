package com.pondit.b4.class9.abstraction;

import java.io.IOException;

public abstract class AbstractAtmBooth {

    private int amount;

    protected String getBank(int bankSelection) {
        if (bankSelection == 1) {
            return "Dutch Bangla Bank";
        } else if (bankSelection == 2) {
            return "Standard Chartered Bank";
        } else if (bankSelection == 3) {
            return "Eastern Bank";
        } else {
            return "NONE";
        }
    }

    protected void setAmount(int amount) {
        this.amount = amount;
    }

    protected int getAmount () {
        return this.amount;
    }
    abstract void performPayment() throws IOException;
}
