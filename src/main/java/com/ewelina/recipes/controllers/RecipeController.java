package com.ewelina.recipes.controllers;

import com.ewelina.recipes.command.RecipeCommand;
import com.ewelina.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    private final String RECIPE_RECIPEFORM_URL = "recipe/recipeform";

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }

    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return RECIPE_RECIPEFORM_URL;
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return RECIPE_RECIPEFORM_URL;
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveAndUpdate(@Valid @ModelAttribute("recipe") RecipeCommand command, BindingResult result) {

        if (result.hasErrors()) {
            result.getAllErrors().forEach(objectError -> {
                log.debug(objectError.toString());
            });
            return RECIPE_RECIPEFORM_URL;
        }
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }




    @GetMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable String id) {
        log.debug("Deleting id: " + id);
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }


}
