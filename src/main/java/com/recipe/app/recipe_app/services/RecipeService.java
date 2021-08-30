package com.recipe.app.recipe_app.services;

import com.recipe.app.recipe_app.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
