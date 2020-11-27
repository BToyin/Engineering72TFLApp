package com.sparta.eng72.journeyplanner.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class JourneyControllerTest {


    @Autowired
    JourneyController journeyController;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void jouneyControllerTest() {
        Assertions.assertNotNull(journeyController);
    }

    @Test
    public void getJourneyTest() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(model().attributeExists("stations"));
    }
}
