package com.thoughtworks.shoppingCart;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@org.springframework.stereotype.Service
@ExtendWith(MockitoExtension.class)
public class ShoppingCartServiceTest {

    @Mock
    private ShoppingCartRepository repository;
    @InjectMocks
    private Service service;
    private static Item book;

    @BeforeAll
    static void setup(){
        book = new Item("book",30.0);
    }

    @Test
    void shouldReturnAllTheItemsThatAreInTheCartAndTheTotalPrice(){
        List<Item> expectedListOfItems = List.of(book);
        ItemDTO expectedBill = new ItemDTO(expectedListOfItems,30.0);
        when(repository.findAll()).thenReturn(expectedListOfItems);

        ItemDTO actualBill = service.getItems();
        assertThat(actualBill,is(equalTo(expectedBill)));
    }

    @Test
    void shouldReturnItemIdWhenAnItemIsAddedToTheCart(){
        int productId = book.getId();
        when(repository.save(book)).thenReturn(book);

        int actualId = service.addItem(book);
        assertThat(actualId,is(equalTo(productId)));
    }

    @Test
    void shouldDeleteTheItem() {
        doNothing().when(repository).deleteById(book.getId());
        service.removeItem(book.getId());

        verify(repository,times(1)).deleteById(book.getId());
    }
}
