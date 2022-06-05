package com.thoughtworks.shoppingCart;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class ShoppingCartController {
    ShoppingCart shoppingCart = new ShoppingCart();

    @PostMapping("/item")
    ResponseEntity<Void> addToCart(@RequestBody Item item){
        shoppingCart.add(item);
        return ResponseEntity.status(CREATED).build();
    }

}
