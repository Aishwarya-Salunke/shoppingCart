package com.thoughtworks.shoppingCart;

public class Item {
    private int id;

    private String name;

    public Item(int id,String name){
        this.id = id;
        this.name = name;
    }

    public int getItemId() {
        return id;
    }

    public String getItemName() {
        return name;
    }
}