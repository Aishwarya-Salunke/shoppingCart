package com.thoughtworks.shoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface ShoppingCartRepository extends JpaRepository<Item,Integer> {
}
