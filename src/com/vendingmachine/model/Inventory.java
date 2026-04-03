package com.vendingmachine.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getAvailableItems() {
        return new ArrayList<>(productList);
    }

    public void reduceQuantity(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(product.getId())) {
                productList.remove(i);
                return;
            }
        }
    }

    public boolean isAvailable(Product product) {
        for (Product item : productList) {
            if (item.getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }
}
