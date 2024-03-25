package com.in28minutes.unittesting.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.RequestResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void HelloWorldTest_basic() throws Exception {

    /*
        // call GET "/hello-world" (Header) application/json

        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-world")
                        .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();

        // verify "Hello World"
        assertEquals("puppy", result.getResponse().getContentAsString());
    */

        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-world")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())             // or .andExpect(status(200))
                .andExpect(content().string("Hello-World"))   // or .andExpect(content().json("Hello-World")) for real JSON content in response
                .andReturn();

        // verify "Hello World"
        // assertEquals("Hello-World", result.getResponse().getContentAsString());
        // In simple cases, we don't need assert statement, but in more complex JSON response, we need Assert statements


    }
}
