package com.thoughtworks.shoppingCart;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;


@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private Repository repository;

    public UUID addItem(Item item){
        return repository.addItem(item);
    }

    public Bill getItems() {
        List<Item> itemsInCart = repository.getItems();
        Bill bill = new Bill(itemsInCart,totalPrice(itemsInCart));
        return bill;
    }

    public void removeItem(UUID id) {
        repository.removeItem(id);
    }

    private double totalPrice(List<Item> itemsInCart){
        double totalPrice = 0;
        for(Item item : itemsInCart){
            totalPrice +=item.getPrice();
        }
        return totalPrice;
    }

}
