package com.sparta.eng72.chucknorrisjokes.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class JokeControllerTest {

    @Mock
    private JokeService jokeService = Mockito.mock(JokeService.class);

    @Mock
    private CategoryService categoryService = Mockito.mock(CategoryService.class);

    @InjectMocks
    private JokeController jokeController;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void jouneyControllerTest() {
        Assertions.assertNotNull(jokeController);
    }

    @Test
    public void getCategoriesTest() throws Exception {
        List<Category> categories = new ArrayList<>();
        when(categoryService.getAllCategories()).thenReturn(categories);
        List<Category> expected = new ArrayList<>();
        Assertions.assertEquals(expected, categories);
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    public void getJokesTest() throws Exception {
        Joke jokes = new Joke();
        when(jokeService.getAllJokes("blank")).thenReturn(jokes);
        mockMvc.perform(post("/?category=blank")).andExpect(status().isOk());
    }
}
