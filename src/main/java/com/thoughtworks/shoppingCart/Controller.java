package com.thoughtworks.shoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class Controller {

    @Autowired
    Service shoppingCart;

    @PostMapping("/shopping-cart/items")
    ResponseEntity<UUID> addToCart(@RequestBody Item item){
        UUID id = shoppingCart.addItem(item);
        return new ResponseEntity<>(id,CREATED);
    }

    @GetMapping("/shopping-cart/items")
    Bill view(){
        return shoppingCart.getItems();
    }

    @DeleteMapping("/shopping-cart/items/{id}")
    void deleteItem(@PathVariable UUID id) throws Exception {
        shoppingCart.removeItem(id);
    }
}