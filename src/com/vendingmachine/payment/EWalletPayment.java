package com.vendingmachine.payment;

public class EWalletPayment implements PaymentStrategy {
    private String walletId;

    public EWalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public boolean pay(double amount) {
        return walletId != null && !walletId.isBlank();
    }
}
