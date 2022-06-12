package com.thoughtworks.shoppingCart;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@org.springframework.stereotype.Service
@ExtendWith(MockitoExtension.class)
public class ShoppingCartServiceTest {

    @Mock
    private Repository repository;
    @InjectMocks
    private Service service;
    private static Item book;
    private static Item pen;

    @BeforeAll
    static void setup(){
        book = new Item("book",30.0);
        pen = new Item("pen",10.0);
    }

    @Test
    void shouldReturnAllTheItemsThatAreInTheCartAndTheTotalPrice(){
        List<Item> expectedListOfItems = List.of(book);
        Bill expectedBill = new Bill(expectedListOfItems,30.0);
        when(repository.getItems()).thenReturn(expectedListOfItems);

        Bill actualBill = service.getItems();
        assertThat(actualBill,is(equalTo(expectedBill)));
    }

    @Test
    void shouldReturnItemIdWhenAnItemIsAddedToTheCart(){
        UUID productId = service.addItem(book);
        when(repository.addItem(book)).thenReturn(productId);

        UUID actualId = service.addItem(book);
        assertThat(actualId,is(equalTo(productId)));
    }

    @Test
    void shouldDeleteTheItem() {
        doNothing().when(repository).removeItem(book.getId());
        service.removeItem(book.getId());

        verify(repository,times(1)).removeItem(book.getId());
    }
}
