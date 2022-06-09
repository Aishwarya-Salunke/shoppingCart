package com.thoughtworks.shoppingCart;

import java.util.Objects;
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

    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(!(obj instanceof Item)){
            return false;
        }
        Item item = (Item)obj;
        return getPrice() == item.getPrice() && Objects.equals(getId(), item.getId()) && Objects.equals(getName(), item.getName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(id,name,price);
    }


}