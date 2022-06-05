package com.thoughtworks.shoppingCart;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class ShoppingCartController {
    ShoppingCart shoppingCart = new ShoppingCart();

    @PostMapping("/item")
    ResponseEntity<Void> addToCart(@RequestBody Item item){
        shoppingCart.add(item);
        return ResponseEntity.status(CREATED).build();
    }

    @DeleteMapping("/item/{id}")
    void deleteItem(@PathVariable int id){
        Item item = shoppingCart.stream().filter(it -> it.getItemId()==id).findFirst().orElse(null);
        shoppingCart.remove(item);
    }
}
