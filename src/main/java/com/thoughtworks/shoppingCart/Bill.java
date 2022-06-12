package com.thoughtworks.shoppingCart;

import java.util.List;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Double.compare(bill.totalPrice, totalPrice) == 0 && Objects.equals(itemsInCart, bill.itemsInCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemsInCart, totalPrice);
    }
}