package com.recipe.app.recipe_app.services;

import com.recipe.app.recipe_app.model.Recipe;
import com.recipe.app.recipe_app.repositories.RecipeRepository;

import java.util.Set;

public interface RecipeService {
    Recipe findById(Long l);
    Set<Recipe> getRecipes();
}
