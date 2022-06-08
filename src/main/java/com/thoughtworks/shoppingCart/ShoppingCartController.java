package com.thoughtworks.shoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCart;

    @PostMapping("/shopping-cart/items")
    ResponseEntity<UUID> addToCart(@RequestBody Item item){
        UUID id = shoppingCart.addToCart(item);
        return new ResponseEntity<>(id,CREATED);
    }

    @GetMapping("/shopping-cart/items")
    List<Item> view(){
        return shoppingCart.getItems();
    }

    @DeleteMapping("/shopping-cart/items/{id}")
    void deleteItem(@PathVariable UUID id){
        shoppingCart.removeItem(id);
    }
}