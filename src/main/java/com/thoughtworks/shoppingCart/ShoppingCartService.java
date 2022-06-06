package com.thoughtworks.shoppingCart;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {
    private List<Item> itemsInCart = new ArrayList<Item>();

    public void addToCart(Item item){
        itemsInCart.add(item);
    }
    public List<Item> getItems() {
        return itemsInCart;
    }

    public void removeItem(int id){
        Item item = itemsInCart.stream().filter(it -> it.getItemId()==id).findFirst().orElse(null);
        itemsInCart.remove(item);
    }
}
