package com.vendingmachine.model;

public class SoftDrink extends Product {
    private final int volume;

    public SoftDrink(String id, String name, double price, int volume) {
        super(id, name, price);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }
}
