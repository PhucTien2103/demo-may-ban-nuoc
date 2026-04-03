package com.vendingmachine.payment;

public interface PaymentStrategy {
    boolean pay(double amount);
}
