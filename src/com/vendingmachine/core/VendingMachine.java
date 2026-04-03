package com.vendingmachine.core;

import com.vendingmachine.factory.ProductFactory;
import com.vendingmachine.model.Inventory;
import com.vendingmachine.model.Product;
import com.vendingmachine.payment.PaymentStrategy;

import java.util.List;

public class VendingMachine {
    private String machineId;
    private String location;
    private Inventory inventory;
    private ProductFactory productFactory;
    private PaymentStrategy paymentStrategy;
    private Product selectedProduct;

    public VendingMachine(String machineId, String location, Inventory inventory) {
        this.machineId = machineId;
        this.location = location;
        this.inventory = inventory;
        this.productFactory = new ProductFactory();
    }

    public void addProductByType(String productType) {
        Product product = productFactory.createProduct(productType);
        inventory.addProduct(product);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void displayProducts() {
        List<Product> products = inventory.getAvailableItems();
        System.out.println("=== Product List ===");
        for (Product product : products) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }

    public void selectProduct(Product product) {
        if (!inventory.isAvailable(product)) {
            System.out.println("Product out of stock.");
            selectedProduct = null;
            return;
        }
        selectedProduct = product;
        System.out.println("Selected: " + product.getName());
    }

    public void processPayment() {
        if (selectedProduct == null) {
            System.out.println("No product selected.");
            return;
        }
        if (paymentStrategy == null) {
            System.out.println("Payment method not selected.");
            return;
        }

        boolean isPaid = paymentStrategy.pay(selectedProduct.getPrice());
        if (isPaid) {
            dispenseProduct();
            updateStock();
        } else {
            System.out.println("Payment failed.");
        }
    }

    public void dispenseProduct() {
        if (selectedProduct != null) {
            System.out.println("Dispensed: " + selectedProduct.getName());
        }
    }

    public void updateStock() {
        if (selectedProduct != null) {
            inventory.reduceQuantity(selectedProduct);
            selectedProduct = null;
        }
    }
}
