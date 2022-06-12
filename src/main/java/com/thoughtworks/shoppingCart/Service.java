package com.thoughtworks.shoppingCart;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private ShoppingCartRepository repository;

    public int addItem(Item item){
        return (repository.save(item).getId());
    }

    public Bill getItems() {
        List<Item> itemsInCart = repository.findAll();
        Bill bill = new Bill(itemsInCart,totalPrice(itemsInCart));
        return bill;
    }

    public void removeItem(int id) {
        repository.deleteById(id);
    }

    private double totalPrice(List<Item> itemsInCart){
        double totalPrice = 0;
        for(Item item : itemsInCart){
            totalPrice +=item.getPrice();
        }
        return totalPrice;
    }

}
