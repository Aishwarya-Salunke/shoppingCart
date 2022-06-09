package com.thoughtworks.shoppingCart;

import java.util.List;


public class Bill {
    private List<Item> itemsInCart;
    private double totalPrice;
    public Bill(List<Item> itemsInCart, double totalPrice) {
        this.totalPrice = totalPrice;
        this.itemsInCart = itemsInCart;
    }

    public List<Item> getItemsInCart() {
        return itemsInCart;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
