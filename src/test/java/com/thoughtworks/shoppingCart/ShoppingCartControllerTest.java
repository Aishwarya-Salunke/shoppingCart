package com.thoughtworks.shoppingCart;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShoppingCartController.class)
public class ShoppingCartControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ShoppingCartService shoppingCartService;

    @Test
    void getItemsInShoppingCart() throws Exception{
        Mockito.when(shoppingCartService.getItems()).thenReturn(Arrays.asList(new Item(1,"Book",30)));

        mockMvc.perform(MockMvcRequestBuilders.get("/shopping-cart/items"))
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(new Item(1,"Book",30)))))
                .andExpect(status().isOk());

        Mockito.verify(shoppingCartService).getItems();
    }

}
