package com.vendingmachine.model;

public class MineralWater extends Product {
    private final double phValue;

    public MineralWater(String id, String name, double price, double phValue) {
        super(id, name, price);
        this.phValue = phValue;
    }

    public double getPhValue() {
        return phValue;
    }
}
