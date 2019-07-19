package com.ewelina.recipes.controllers;

import com.ewelina.recipes.services.RecipeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@AllArgsConstructor
@Controller
public class IndexController {

    private final RecipeService recipeService;

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("getting index page");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
