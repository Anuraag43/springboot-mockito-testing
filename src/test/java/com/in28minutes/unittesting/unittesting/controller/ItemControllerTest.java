package com.in28minutes.unittesting.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void dummyItem_basic() throws Exception {

    /**/

        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("\n" +
                        "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();


/*

//Success ==>

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                        .andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                                .andReturn();
// Failue ==>
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                        .andExpect(content().string("\n" +
                                "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                                .andReturn();

This will Fail because, when comparing JSON as String any extra line or extra space will cause it to fail.
Instead, use JSON which will pass if spaces varies as long as JSON format still exists.

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                        .andExpect(content().json("\n" +
                                "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                                 .andReturn();

Also, with json() method we can ignore few fields in the JSON object and it still succeeds as long as
the format is correct.

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("\n" +
                        "{\"id\":1,\"name\":\"Ball\",\"price\":10}"))
                                .andReturn();

         */



    }
}
