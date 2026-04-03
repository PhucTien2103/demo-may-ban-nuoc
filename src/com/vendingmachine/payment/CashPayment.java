package com.vendingmachine.payment;

public class CashPayment implements PaymentStrategy {
    private double amountTendered;

    public CashPayment(double amountTendered) {
        this.amountTendered = amountTendered;
    }

    @Override
    public boolean pay(double amount) {
        return amountTendered >= amount;
    }
}
