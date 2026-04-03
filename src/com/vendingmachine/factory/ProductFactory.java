package com.vendingmachine.factory;

import com.vendingmachine.model.MineralWater;
import com.vendingmachine.model.Product;
import com.vendingmachine.model.SoftDrink;
import com.vendingmachine.model.Tea;

public class ProductFactory {
    public Product createProduct(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Product type must not be null.");
        }

        return switch (type.trim().toLowerCase()) {
            case "tea" -> new Tea("T01", "Tea", 12_000, 50);
            case "softdrink", "soft_drink", "soft-drink" -> new SoftDrink("S01", "Soft Drink", 15_000, 330);
            case "mineralwater", "mineral_water", "mineral-water", "water" ->
                    new MineralWater("M01", "Mineral Water", 10_000, 7.2);
            default -> throw new IllegalArgumentException("Unsupported product type: " + type);
        };
    }
}
