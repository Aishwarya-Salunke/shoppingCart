package com.thoughtworks.shoppingCart;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controller.class)
public class ShoppingCartControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private Service shoppingCartService;

    private static Item item;
    @BeforeAll
    static void setup(){
        item = new Item("Book",30);
    }

    @Test
    void getItemsInShoppingCart() throws Exception{
        ItemDTO bill = new ItemDTO(List.of(item),30);
        Mockito.when(shoppingCartService.getItems()).thenReturn(bill);

        mockMvc.perform(MockMvcRequestBuilders.get("/shopping-cart/items"))
                .andExpect(content().json(objectMapper.writeValueAsString(bill)))
                .andExpect(status().isOk());


        Mockito.verify(shoppingCartService).getItems();
    }

    @Test
    void addItemToShoppingCart() throws Exception{
        Mockito.when(shoppingCartService.addItem(item)).thenReturn(item.getId());

        mockMvc.perform(MockMvcRequestBuilders.post("/shopping-cart/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(item)))
                .andExpect(content().json(objectMapper.writeValueAsString(item.getId())))
                .andExpect(status().isCreated());

        Mockito.verify(shoppingCartService).addItem(item);
    }

    @Test
    void deleteItemFromShoppingCart() throws Exception{
        Mockito.doNothing().when(shoppingCartService).removeItem(item.getId());

        mockMvc.perform(MockMvcRequestBuilders.delete("/shopping-cart/items/{id}",item.getId()))
                .andExpect(status().isOk());

        Mockito.verify(shoppingCartService).removeItem(item.getId());
    }
}