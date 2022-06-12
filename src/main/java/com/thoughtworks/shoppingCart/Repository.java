package com.thoughtworks.shoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Repository
public class Repository {
    private List<Item> itemsInCart = new ArrayList<Item>();

    public UUID addItem(Item item){
        itemsInCart.add(item);
        return item.getId();
    }

    public List<Item> getItems() {
        return itemsInCart;
    }

    public void removeItem(UUID id) {
             Item item = itemsInCart.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
             itemsInCart.remove(item);
    }
}
