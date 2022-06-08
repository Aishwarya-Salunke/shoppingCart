package com.thoughtworks.shoppingCart;

import java.util.UUID;

public class Item {

    private final UUID id;

    private final String name;

    private final double price;

    public Item(String name, double price){
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}