package com.vendingmachine.model;

public class Tea extends Product {
    private final int sugarLevel;

    public Tea(String id, String name, double price, int sugarLevel) {
        super(id, name, price);
        this.sugarLevel = sugarLevel;
    }

    public int getSugarLevel() {
        return sugarLevel;
    }
}
