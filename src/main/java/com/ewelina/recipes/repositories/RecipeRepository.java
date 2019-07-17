package com.ewelina.recipes.repositories;

import com.ewelina.recipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {


}
