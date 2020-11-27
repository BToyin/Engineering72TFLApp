package com.sparta.eng72.chucknorrisjokes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JokeController {

    private JokeService jokeService;
    private CategoryService categoryService;

    @Autowired
    public JokeController(JokeService jokeService, CategoryService categoryService) {
        this.jokeService = jokeService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String getAllCategories(ModelMap modelMap){
        List<Category> categories = categoryService.getAllCategories;
        modelMap.addAttribute("categories", categories);
        return "index";
    }

    @PostMapping("/")
    public String getJokes(ModelMap modelMap, @RequestParam(value = "category") String category){
        List<Joke> jokes = jokeService.getAlljokes(category);
        modelMap.addAttribute("jokes", jokes);
        modelMap.addAttribute("message", "The greatest chuck Norris jokes for this category");
        return "index";
    }

}
