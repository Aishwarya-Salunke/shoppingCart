package com.thoughtworks.shoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCart;

    @PostMapping("/shopping-cart/add-item")
    ResponseEntity<Void> addToCart(@RequestBody Item item){
        shoppingCart.addToCart(item);
        return ResponseEntity.status(CREATED).build();
    }

    @GetMapping("/shopping-cart/view")
    List<Item> item(){
        return shoppingCart.getItems();
    }

    @DeleteMapping("/shopping-cart/delete-item/{id}")
    void deleteItem(@PathVariable int id){
        shoppingCart.removeItem(id);
    }
}