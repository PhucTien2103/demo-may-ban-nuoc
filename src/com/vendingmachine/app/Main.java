package com.vendingmachine.app;

import com.vendingmachine.core.VendingMachine;
import com.vendingmachine.model.Inventory;
import com.vendingmachine.model.Product;
import com.vendingmachine.payment.CashPayment;
import com.vendingmachine.payment.EWalletPayment;
import com.vendingmachine.payment.StudentCardPayment;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        VendingMachine machine = new VendingMachine("VM01", "Campus A", inventory);
        machine.addProductByType("water");
        machine.addProductByType("water");
        machine.addProductByType("tea");
        machine.addProductByType("softdrink");

        Product p1 = inventory.getAvailableItems().get(0);
        Product p2 = inventory.getAvailableItems().get(2);

        machine.displayProducts();

        machine.selectProduct(p1);
        machine.setPaymentStrategy(new CashPayment(20_000));
        machine.processPayment();

        machine.selectProduct(p2);
        machine.setPaymentStrategy(new StudentCardPayment("SV12345"));
        machine.processPayment();

        machine.selectProduct(p1);
        machine.setPaymentStrategy(new EWalletPayment("WALLET_001"));
        machine.processPayment();
    }
}
