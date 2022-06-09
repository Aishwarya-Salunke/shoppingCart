package com.thoughtworks.shoppingCart;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingCartService {
    private List<Item> itemsInCart = new ArrayList<Item>();

    public UUID addItem(Item item){
        itemsInCart.add(item);
        return item.getId();
    }

    public Bill getItems() {
        return new Bill(itemsInCart,totalPrice());
    }

    public void removeItem(UUID id){
        Item item = itemsInCart.stream().filter(it -> it.getId()==id).findFirst().orElse(null);
        itemsInCart.remove(item);
    }

    public double totalPrice(){
        double totalPrice = 0;
        for(Item item : itemsInCart){
           totalPrice +=item.getPrice();
        }
        return totalPrice;
    }
}
