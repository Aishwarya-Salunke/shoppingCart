package com.thoughtworks.shoppingCart;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Item {
    private final String name;
    private final double price;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    public int getId() {
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