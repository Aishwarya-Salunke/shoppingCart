package com.thoughtworks.shoppingCart;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingCartService {
    private List<Item> itemsInCart = new ArrayList<Item>();

    public UUID addToCart(Item item){
        itemsInCart.add(item);
        return item.getId();
    }

    public List<Item> getItems() {
        return itemsInCart;
    }

    public void removeItem(UUID id){
        Item item = itemsInCart.stream().filter(it -> it.getId()==id).findFirst().orElse(null);
        itemsInCart.remove(item);
    }
}
