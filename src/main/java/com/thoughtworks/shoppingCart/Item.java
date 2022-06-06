package com.thoughtworks.shoppingCart;

public class Item {
    private final int itemId;

    private final String itemName;

    public Item(int id,String name){
        this.itemId = id;
        this.itemName = name;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }
}