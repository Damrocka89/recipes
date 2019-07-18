package com.ewelina.recipes.services;

import com.ewelina.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
